/*
 * @lc app=leetcode id=680 lang=java
 *
 * [680] Valid Palindrome II
 */

// @lc code=start
class Solution {
    boolean isPalindrome(String s){
        System.out.println("Judging String "+s);
        for(int i=0; i<s.length()/2; i++){
            if(s.charAt(i) != s.charAt(s.length()-i-1)){
                return false;
            }
        }
        return true;
    }
    // boolean modify(String s, boolean modified){
    //     if(modified){
    //         return isPalindrome(s);
    //     }
    //     int n = s.length();
    //     if(n<=1){
    //         return true;
    //     }
    //     if(s.charAt(0) == s.charAt(n-1)){
    //         return modify(s.substring(1, n-1), false);
    //     }
    //     return modify(s.substring(0, n-1), true) || modify(s.substring(1, n), true);
    // }
    public boolean validPalindrome(String s) {
        // return modify(s, false);
        if(isPalindrome(s)){
            return true;
        }
        int left = 0, right = s.length();
        while(left < right && s.charAt(left) == s.charAt(right-1)){
            left ++;
            right --;
        }
        return isPalindrome(s.substring(left, right-1)) || isPalindrome(s.substring(left+1, right));
        // boolean notModified = true;
        // while(left <= right){
        //     if(s.charAt(left) == s.charAt(right)){
        //         left++;
        //         right--;
        //         continue;
        //     }
        //     if(s.charAt(left) == s.charAt(right-1) && notModified){
        //         left++;
        //         right--;
        //         right--;
        //         notModified = false;
        //         continue;
        //     }
        //     if(s.charAt(left+1) == s.charAt(right) && notModified){
        //         left++;
        //         left++;
        //         right--;
        //         notModified = false;
        //         continue;
        //     }
        //     return false;
        // }
        // return true;
    }
}
// @lc code=end

