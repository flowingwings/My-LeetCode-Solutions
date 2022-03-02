/*
 * @lc app=leetcode id=258 lang=java
 *
 * [258] Add Digits
 */

// @lc code=start

// I wrote some numbers and their addDigits result,
// and found the rule and derived the O(1) algorithm.
// Proof is easy and unnecessary to write it here.
class Solution {
    public int addDigits(int num) {
        if(num == 0) return 0;
        return (num % 9) != 0 ? (num % 9) : 9;
    }
}
// @lc code=end

