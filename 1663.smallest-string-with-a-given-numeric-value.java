import java.util.Arrays;

/*
 * @lc app=leetcode id=1663 lang=java
 *
 * [1663] Smallest String With A Given Numeric Value
 */

// @lc code=start
class Solution {
    public String getSmallestString(int n, int k) {
        StringBuilder sb = new StringBuilder();
        int[] charV = new int[n];
        for(int i=0; i<n; i++){
            charV[i] = 1;
        }
        k -= n;
        int index = n-1;
        while(k!=0){
            charV[index] += Math.min(25, k);
            index --;
            k -= Math.min(25, k);
        }
        for(int i: charV){
            sb.append((char)('a'+(i-1)));
        }
        return sb.toString();
    }
}
// @lc code=end

