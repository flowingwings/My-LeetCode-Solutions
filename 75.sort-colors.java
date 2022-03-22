import java.util.Arrays;

/*
 * @lc app=leetcode id=75 lang=java
 *
 * [75] Sort Colors
 */

// @lc code=start
class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int redIndex = 0;
        int blueIndex = n-1;
        // while(nums[redIndex] == 0) {redIndex ++;}
        // while(nums[blueIndex] == 2) {blueIndex --;}
        int temp;
        for(int i=redIndex; i<n; i++){
            if(i > blueIndex){
                break;
            }
            // while(nums[redIndex] == 0) {redIndex ++;}
            // while(nums[blueIndex] == 2) {blueIndex --;}
            if(nums[i] == 0){
                temp = nums[redIndex];
                nums[redIndex] = nums[i];
                nums[i] = temp;
                redIndex ++;
            }
            else if(nums[i] == 1){
                continue;
            }
            else{
                temp = nums[blueIndex];
                nums[blueIndex] = nums[i];
                nums[i] = temp;
                blueIndex --;
                i--;
            }
            System.out.println(i + "..."+Arrays.toString(nums));
        }
        return;
    }
}
// @lc code=end

