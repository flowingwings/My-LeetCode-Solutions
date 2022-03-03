/*
 * @lc app=leetcode id=35 lang=java
 *
 * [35] Search Insert Position
 */

// @lc code=start

// Inspired by answer to Problem 34.
class Solution {
    public int searchInsert(int[] nums, int target) {
        int index = binarySearch(nums, target);
        return index;
    }
    
    int binarySearch(int[] nums, int target){
        int left = 0, right = nums.length - 1, ans = nums.length;
        while(left <= right){
            int mid = (left + right) >> 1;
            if(nums[mid] < target){
                left = mid + 1;
            }
            else{
                right = mid - 1;
                ans = mid;
            }
        }
        return ans;
    }
}
// @lc code=end

