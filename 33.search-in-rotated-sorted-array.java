/*
 * @lc app=leetcode id=33 lang=java
 *
 * [33] Search in Rotated Sorted Array
 */

// @lc code=start
//Copied from https://leetcode-cn.com/problems/search-in-rotated-sorted-array/solution/ji-jian-solution-by-lukelee/
//Genius usage of ^.
class Solution {
    public int search(int[] nums, int target) {
        int len = nums.length;
        if(len==0){
            return -1;
        }
        int l=0, r=len-1;
        while(l<r){
            int mid=(l+r)/2;
            if((nums[0]>nums[mid])^(nums[0]>target)^(target>nums[mid])){
                l=mid+1;
            }
            else{
                r=mid;
            }
        }
        return l==r&&nums[l]==target?l:-1;
    }
}
// @lc code=end

