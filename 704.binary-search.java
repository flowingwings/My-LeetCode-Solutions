/*
 * @lc app=leetcode id=704 lang=java
 *
 * [704] Binary Search
 */

// @lc code=start
class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1;
        int pivot;
        while(left <= right){
            pivot = (left+right)/2;
            if(nums[pivot] == target){
                return pivot;
            }
            if(nums[pivot] < target){
                left = pivot + 1;
            }
            else{
                right = pivot - 1;
            }
        }
        return -1;
    }
}
// @lc code=end

