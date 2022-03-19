/*
 * @lc app=leetcode id=63 lang=java
 *
 * [63] Unique Paths II
 */

// @lc code=start
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] dp = new int[n];
        dp[n-1] = obstacleGrid[m-1][n-1]==1?0:1;
        for(int i=n-2; i>-1; i--){
            dp[i] = obstacleGrid[m-1][i]==1?0:dp[i+1];
        }
        for(int j=m-2; j>-1; j--){
            dp[n-1] = obstacleGrid[j][n-1]==1?0:dp[n-1];
            for(int i=n-2; i>-1; i--){
                dp[i] = obstacleGrid[j][i]==1?0:(dp[i]+dp[i+1]);
            }
        }
        return dp[0];
    }
}
// @lc code=end

