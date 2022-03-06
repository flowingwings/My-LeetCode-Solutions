/*
 * @lc app=leetcode id=1359 lang=java
 *
 * [1359] Count All Valid Pickup and Delivery Options
 */

// @lc code=start
class Solution {
    static int MOD = 1_000_000_007;
    public int countOrders(int n) {
        // if(n==1){
        //     return 1;
        // }
        // int lastAns = 2*n-1;
        // // ansMulti = 1+2+...+lastAns;
        // int ansMulti = (lastAns)*(lastAns+1)/2;
        // return (countOrders(n-1)*ansMulti) % MOD;
        long ans = 1;
        for(int i=1; i<=n; i++){
            ans = ans*i*(2*i-1);
            ans = ans % MOD;
        }
        return (int)ans;
    }
}
// @lc code=end

