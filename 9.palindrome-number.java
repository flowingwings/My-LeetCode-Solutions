/*
 * @lc app=leetcode id=9 lang=java
 *
 * [9] Palindrome Number
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(int x) {
        String intStr = Integer.toString(x);
        int len = intStr.length();
        for(int i=0; i < len >> 1; i++){
            if(intStr.charAt(i) != intStr.charAt(len - 1 - i))
                return false;
        }
        return true;
    }
}
// @lc code=end

