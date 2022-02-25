/*
 * @lc app=leetcode id=537 lang=java
 *
 * [537] Complex Number Multiplication
 */

// @lc code=start
class Solution {
    public String complexNumberMultiply(String num1, String num2) {
        String ans = "";
        int re1 = Integer.parseInt(num1.split("\\+")[0]);
        int re2 = Integer.parseInt(num2.split("\\+")[0]);
        int im1 = Integer.parseInt(num1.split("\\+")[1].split("i")[0]);
        int im2 = Integer.parseInt(num2.split("\\+")[1].split("i")[0]);
        int re = re1*re2 - im1*im2;
        int im = re1*im2 + re2*im1;
        ans = re + "+" + im + "i";
        return ans;
    }
}
// @lc code=end

