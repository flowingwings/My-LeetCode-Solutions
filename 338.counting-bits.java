/*
 * @lc app=leetcode id=338 lang=java
 *
 * [338] Counting Bits
 */

// @lc code=start
class Solution {
    int countBit(int n){
        int ans = 0;
        while(n != 0){
            ans += n & 1;
            n >>= 1;
        }
        return ans;
    }
    public int[] countBits(int n) {
        int[] ans = new int[n+1];
        // for(int i=0; i<=n; i++){
        //     ans[i]=countBit(i);
        // }

        // for(int i=1; i<=n; i++){
        //     ans[i]=ans[i>>1]+(i&1);
        // }

        int highBit=0;
        for(int i=1; i<=n; i++){
            if((i&(i-1))==0){
                highBit=i;
            }
            ans[i]=ans[i-highBit]+1;
        }
        return ans;
    }
}
// @lc code=end

