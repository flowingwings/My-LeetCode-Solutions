/*
 * @lc app=leetcode id=91 lang=java
 *
 * [91] Decode Ways
 */

// @lc code=start
class Solution {
    // String[] codes = {
    //     "1", "2", "3", "4", "5", "6",
    //     "7", "8", "9", "10", "11", "12",
    //     "13", "14", "15", "16", "17", "18",
    //     "19", "20", "21", "22", "23", "24",
    //     "25", "26"
    // };
    public int numDecodings(String s) {
        int ans = 0;
        int n = s.length();
        int[] dp = new int[n];
        // dp[n] := numDecodings(s[0...n])
        if(s.charAt(0) >= '1' && s.charAt(0) <= '9'){
            dp[0] = 1;
        }
        if(n==1){
            return dp[0];
        }
        if(s.charAt(1) >= '1' && s.charAt(1) <= '9'){
            dp[1] += dp[0];
        }
        if((s.charAt(0) == '1' && s.charAt(1) >= '0' && s.charAt(1) <= '9')
        || (s.charAt(0) == '2' && s.charAt(1) >= '0' && s.charAt(1) <= '6')){
            dp[1] ++;
        }
        for(int i=2; i<n; i++){
            if(s.charAt(i) >= '1' && s.charAt(i) <= '9'){
                dp[i] += dp[i-1];
            }
            if((s.charAt(i-1) == '1' && s.charAt(i) >= '0' && s.charAt(i) <= '9')
            || (s.charAt(i-1) == '2' && s.charAt(i) >= '0' && s.charAt(i) <= '6')){
                dp[i] += dp[i-2];
            }
        }
        return dp[n-1];
    }
}
// @lc code=end

