/*
 * @lc app=leetcode id=991 lang=java
 *
 * [991] Broken Calculator
 */

// @lc code=start
class Solution {
    public int brokenCalc(int startValue, int target) {
        int ans = 0;
        while (target > startValue) {
            if(target % 2 == 1){
                target += 1;
                ans += 1;
            }
            else{
                target /= 2;
                ans += 1;
            }
        }
        return ans + (startValue - target);
    }
}
// @lc code=end

