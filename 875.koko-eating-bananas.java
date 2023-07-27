/*
 * @lc app=leetcode id=875 lang=java
 *
 * [875] Koko Eating Bananas
 */

// @lc code=start
class Solution875 {
    private static void sout(Object o) {
        System.out.println(o);
    }
    public int minEatingSpeed(int[] piles, int h) {
        long left = 1;
        long total = 0;
        for(int pile: piles) {
            total += pile;
        }
        long right = (total / h) + 1;
        long mid = 0;
        while(left < right) {
            mid = left + (right - left) / 2;
            sout("left: " + left + ", right: " + right + ", mid: " + mid);
            int curTime = 0;
            for(int pile: piles) {
                if (pile % mid == 0) {
                    curTime += pile / mid;
                }
                else {
                    curTime += pile / mid + 1;
                }
            }
            if (curTime <= h) {
                right = mid;
            }
            else {
                left = mid + 1;
            }
        }
        return (int)left;
    }
}
// @lc code=end

