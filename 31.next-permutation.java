/*
 * @lc app=leetcode id=31 lang=java
 */

// @lc code=start
class Solution {
    public void nextPermutation(int[] nums) {
        int len=nums.length;
        int leftIndex = len-1;
        while(leftIndex>=1 && nums[leftIndex]<=nums[leftIndex-1]){
            leftIndex--;
        }
        leftIndex--;
        int rightIndex=len-1;
        if(leftIndex>=0){
            while(rightIndex>leftIndex && nums[leftIndex]>=nums[rightIndex]){
                rightIndex--;
            }
            swap(nums, leftIndex, rightIndex);
        }
        System.out.println("l: "+leftIndex);
        System.out.println("r: "+rightIndex);
        rightIndex=len-1;
        while(leftIndex+1<rightIndex){
            swap(nums, leftIndex+1, rightIndex);
            leftIndex++;
            rightIndex--;
        }
        return;
    }
    void swap(int[] nums, int i, int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
// @lc code=end

