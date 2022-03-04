import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=413 lang=java
 *
 * [413] Arithmetic Slices
 */

// @lc code=start

// Calculate arithmetic subarrays so that they are as long as possible.
// Then derive the answer from their length.
class Solution {
    int[] combs = new int[5001];

    public int numberOfArithmeticSlices(int[] nums) {
        combs[3] = 1;
        // int curDiff = 0;
        int len = nums.length;
        int curLen = 2;
        int ans = 0;
        int tempAns = 0;
        List<Integer> subarrayLengths = new ArrayList<>();
        for(int i=2; i<len; i++){
            if(nums[i]+nums[i-2]==2*nums[i-1]){
                curLen ++;
            }
            else{
                curLen = 2;
                tempAns = 0;
            }
            if(curLen >= 3){
                tempAns ++;
                ans += tempAns;
            }
        }
        subarrayLengths.add(curLen);
        // NO NEED TO CALCULATE!
        // for(Integer i: subarrayLengths){
        //     System.out.println("i: "+i);
        //     ans += calc(i);
        // }
        return ans;
    }
    
    // The function below is abundant.
    int calc(int n){
        // 3 -- 1
        // 4 -- 3
        // 5 -- 6
        // 6 -- 10
        // ...
        // n -- (1+2+...+n-2)
        if(n==1 || n==2){
            return 0;
        }
        if(combs[n] != 0){
            return combs[n];
        }
        combs[n] = calc(n-1) + (n-2);
        return combs[n];
    }
}
// @lc code=end

