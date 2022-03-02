import java.util.Arrays;

/*
 * @lc app=leetcode id=45 lang=java
 *
 * [45] Jump Game II
 */

// @lc code=start
class Solution {

    // Although I heard a greedy algorithm from CB, 
    // I still used DP because I thought this situation was different.
    // His problem only needs to judge whether jumping to the end is possible, 
    // while mine needs to calculate the minimun step number.
    // But the result tells me that greedy algorithm is still working...

    public int jump(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[len-1] = 0;
        for(int i = len - 2; i>=0; i--){
            for(int j=Math.min(i+nums[i], len-1); j>i; j--){
                if(dp[j] != Integer.MAX_VALUE)
                    dp[i] = Math.min(dp[i], dp[j] + 1);
            }
        }
        return dp[0];
    }

    // Below is the official answer.
    // Time complexity: O(n).
    // https://leetcode-cn.com/problems/jump-game-ii/solution/tiao-yue-you-xi-ii-by-leetcode-solution/
    
    public int officialAnswer(int[] nums) {
        int len = nums.length;
        int end = 0;
        int maxPos = 0;
        int step = 0;
        for(int i=0; i<len-1; i++){
            maxPos = Math.max(maxPos, i+nums[i]);
            if(i==end){
                end=maxPos;
                step++;
            }
        }
        return step;
    }
}
// @lc code=end

