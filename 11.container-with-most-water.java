/*
 * @lc app=leetcode id=11 lang=java
 *
 * [11] Container With Most Water
 */

// Two pointer.

// @lc code=start
class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int left = 0, right = n - 1;
        int maxArea = 0;
        while(left < right){
            maxArea = Math.max(maxArea, (right - left) * Math.min(height[left], height[right]));
            if(height[left] < height[right]){
                left ++;
            }
            else{
                right --;
            }
        }
        return maxArea;
    }
}
// @lc code=end

