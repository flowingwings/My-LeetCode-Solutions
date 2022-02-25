/*
 * @lc app=leetcode id=2016 lang=java
 *
 * [2016] Maximum Difference Between Increasing Elements
 */

// @lc code=start
class Solution {
    public int maximumDifference(int[] nums) {
        int ans = 0;
        int tempmin = Integer.MAX_VALUE;
        for(int i=0; i<nums.length; i++){
            if(nums[i] < tempmin){
                tempmin = nums[i];
            }
            else if(nums[i] - tempmin > ans){
                ans = nums[i] - tempmin;
            }
        }
        if(ans == 0){
            return -1;
        }
        return ans;
    }
}
// @lc code=end

