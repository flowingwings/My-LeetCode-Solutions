import java.util.Stack;

/*
 * @lc app=leetcode id=321 lang=java
 *
 * [321] Create Maximum Number
 */

// @lc code=start
class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] ans = new int[k];
        for(int i=0; i<=k; i++){
            if(i>nums1.length || k-i>nums2.length){
                continue;
            }
            int[] temp = merge(select(nums1, i), select(nums2, k-i));
            if(greaterArr(temp, ans, 0, 0) > 0){
                ans = temp;
            }
        }
        return ans;
    }
    int[] select(int[] nums, int i){
    //     Stack<Integer> s = new Stack();
    //     int drop = nums.length - i;
    //     for(int n: nums){
    //         while(drop!=0 && !s.empty() && s.peek()<n){
    //             s.pop();
    //             drop --;
    //         }
    //         s.push(n);
    //     }
    //     int[] ans = new int[i];
    //     for(int j=0; j<i; j++){
    //         ans[i-j-1]=s.pop();
    //     }
    //     return ans;
        int length = nums.length;
        int[] stack = new int[i];
        int top = -1;
        int remain = length - i;
        for (int j = 0; j < length; j++) {
            int num = nums[j];
            while (top >= 0 && stack[top] < num && remain > 0) {
                top--;
                remain--;
            }
            if (top < i - 1) {
                stack[++top] = num;
            } else {
                remain--;
            }
        }
        return stack;
    }

    int[] merge(int[] nums1, int[] nums2){
        int l1 = nums1.length, l2 = nums2.length;
        if(l1 == 0){
            return nums2;
        }
        if(l2 == 0){
            return nums1;
        }
        int mergeLength = l1+l2;
        int i1=0, i2=0;
        int[] res = new int[mergeLength];
        for(int i=0; i<mergeLength; i++){
            if(greaterArr(nums1, nums2, i1, i2) > 0){
                res[i] = nums1[i1];
                i1++;
            }
            else{
                res[i] = nums2[i2];
                i2++;
            }
        }
        return res;
    }
    int greaterArr(int[] nums1, int[] nums2, int i1, int i2){
        int l1 = nums1.length, l2 = nums2.length;
        while(i1<l1 && i2<l2){
            int diff = nums1[i1] - nums2[i2];
            if(diff != 0){
                return diff;
            }
            i1++;
            i2++;
        }
        return (l1-i1) - (l2-i2);
    }
}
// @lc code=end

