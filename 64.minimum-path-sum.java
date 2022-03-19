import java.util.Arrays;

/*
 * @lc app=leetcode id=64 lang=java
 *
 * [64] Minimum Path Sum
 */

// @lc code=start
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] dp = grid[m-1];
        for(int j=n-2; j>=0; j--){
            dp[j] = dp[j]+dp[j+1];
        }
        for(int i=m-2; i>=0; i--){
            dp[n-1] += grid[i][n-1];
            for(int j=n-2; j>=0; j--){
                dp[j] = Math.min(dp[j], dp[j+1])+grid[i][j];
            }
        }
        return dp[0];
    }
}
// @lc code=end

