/*
 * @lc app=leetcode id=62 lang=java
 *
 * [62] Unique Paths
 */

// @lc code=start
class Solution {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        for(int i=0; i<n; i++){
            dp[i] = 1;
        }
        for(int j=1; j<m; j++){
            for(int i=1; i<n; i++){
                dp[i] = dp[i] + dp[i-1];
            }
        }
        return dp[n-1];
    }
}
// @lc code=end

