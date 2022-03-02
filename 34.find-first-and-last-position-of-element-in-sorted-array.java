/*
 * @lc app=leetcode id=34 lang=java
 *
 * [34] Find First and Last Position of Element in Sorted Array
 */

// @lc code=start
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int leftIndex = binarySearch(nums, target, true);
        int rightIndex = binarySearch(nums, target, false) - 1;
        if(leftIndex <= rightIndex 
        // && nums[leftIndex] == target && nums[rightIndex] == target
        ){
            return new int[]{leftIndex, rightIndex};
        }
        return new int[]{-1, -1};
    }
    
    int binarySearch(int[] nums, int target, boolean lower){
        int left = 0, right = nums.length - 1, ans = nums.length;
        while(left<=right){
            int mid = (left + right)>>1;
            if(nums[mid] > target || (nums[mid] == target && lower)){
                right = mid - 1;
                ans = mid;
            }
            else{
                left = mid + 1;
            }
        }
        return ans;
    }
}
// @lc code=end

