import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=228 lang=java
 *
 * [228] Summary Ranges
 *
 * https://leetcode.com/problems/summary-ranges/description/
 *
 * algorithms
 * Easy (44.61%)
 * Likes:    1859
 * Dislikes: 1048
 * Total Accepted:    275K
 * Total Submissions: 600.6K
 * Testcase Example:  '[0,1,2,4,5,7]'
 *
 * You are given a sorted unique integer array nums.
 * 
 * Return the smallest sorted list of ranges that cover all the numbers in the
 * array exactly. That is, each element of nums is covered by exactly one of
 * the ranges, and there is no integer x such that x is in one of the ranges
 * but not in nums.
 * 
 * Each range [a,b] in the list should be output as:
 * 
 * 
 * "a->b" if a != b
 * "a" if a == b
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [0,1,2,4,5,7]
 * Output: ["0->2","4->5","7"]
 * Explanation: The ranges are:
 * [0,2] --> "0->2"
 * [4,5] --> "4->5"
 * [7,7] --> "7"
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [0,2,3,4,6,8,9]
 * Output: ["0","2->4","6","8->9"]
 * Explanation: The ranges are:
 * [0,0] --> "0"
 * [2,4] --> "2->4"
 * [6,6] --> "6"
 * [8,9] --> "8->9"
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 0 <= nums.length <= 20
 * -2^31 <= nums[i] <= 2^31 - 1
 * All the values of nums are unique.
 * nums is sorted in ascending order.
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        int len = nums.length;
        if(len==0){
            return ans;
        }
        int leftIndex=0, rightIndex=0;
        boolean isNew=false;
        for(int i=0; i<len; i++){
            leftIndex=nums[i];
            while(i>=0 && i<len-1 && nums[i]+1==nums[i+1]){
                i++;
            }
            rightIndex=nums[i];
            if(leftIndex==rightIndex){
                ans.add(Integer.toString(leftIndex));
            }
            else{
                ans.add(Integer.toString(leftIndex)+"->"+Integer.toString(rightIndex));
            }
        }
        return ans;
    }
}
// @lc code=end

