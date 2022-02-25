
/*
 * @lc app=leetcode id=4 lang=java
 *
 * [4] Median of Two Sorted Arrays
 */

// Very Difficult!
// Just copy and paste...
 
// @lc code=start
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length, l2 = nums2.length;
        if(l1 > l2){
            return findMedianSortedArrays(nums2, nums1);
        }
        if(l1 == 0){
            
        }
        int i = 0, j = 0;
        int imin = 0, imax = l1, halfLen = (l1 + l2 + 1) / 2;
        double maxLeft = 1, minRight = 1;
        while(imin <= imax){
            i = (imin + imax) / 2;
            j = halfLen - i;
            if(i < l1 && j > 0 && nums1[i] < nums2[j - 1]){
                imin = i + 1;
            }
            else if(i > 0 && j < l2 && nums1[i - 1] > nums2[j]){
                imax = i - 1;
            }
            else{
                if(i == 0){
                    maxLeft = nums2[j - 1];
                }
                else if(j == 0){
                    maxLeft = nums1[i - 1];
                }
                else{
                    maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);
                }
                
                break;
            }
        }
        if(((l1 + l2) % 2)== 1){
            return maxLeft;
        }
        if(i == l1){
            minRight = nums2[j];
        }
        else if(j == l2){
            minRight = nums1[i];
        }
        else{
            minRight = Math.min(nums1[i], nums2[j]);
        }
        return (maxLeft + minRight) / 2.0;
    }
}
// @lc code=end

