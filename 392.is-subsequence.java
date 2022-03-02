/*
 * @lc app=leetcode id=392 lang=java
 *
 * [392] Is Subsequence
 */

// @lc code=start

// ATTENTION: corner case warning.
class Solution {
    public boolean isSubsequence(String s, String t) {
        // boolean ans = false;
        int len1 = s.length();
        int len2 = t.length();
        boolean[][] visited = new boolean[len1+1][len2+1];
        boolean[][] isSub = new boolean[len1+1][len2+1];
        if(len1 == 0){
            return true;
        }
        if(len2 == 0){
            return false;
        }
        return isSubRecur(s, t, visited, isSub, 0, 0, len1, len2);
    }
    public boolean isSubRecur(String s, String t, boolean visited[][], boolean isSub[][], int m, int n, int len1, int len2){
        if(visited[m][n]){
            return isSub[m][n];
        }
        // System.out.println(s.substring(m));
        // System.out.println(t.substring(n));
        // System.out.println("=====");
        visited[m][n] = true;
        if(m == len1){
            isSub[m][n] = true;
            return true;
        }
        if(n == len2){
            isSub[m][n] = false;
            return false;
        }
        if(s.charAt(m)==t.charAt(n)){
            isSub[m][n] = isSubRecur(s, t, visited, isSub, m+1, n+1, len1, len2)
                || isSubRecur(s, t, visited, isSub, m, n+1, len1, len2);
            return isSub[m][n];
        }
        isSub[m][n] = isSubRecur(s, t, visited, isSub, m, n+1, len1, len2);
        return isSub[m][n];
    }
}
// @lc code=end

