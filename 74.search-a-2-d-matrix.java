/*
 * @lc app=leetcode id=74 lang=java
 *
 * [74] Search a 2D Matrix
 */

// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // boolean ans = true;
        int row = matrix.length, col = matrix[0].length;
        int left = 0, right = row*col-1;
        int pivot = 0, temp = 0;
        while(left <= right){
            pivot = (left + right) / 2;
            temp = matrix[pivot / col][pivot % col];
            if(temp == target){
                System.out.println(pivot);
                return true;
            }
            if(temp < target){
                left = pivot + 1;
                continue;
            }
            if(temp > target){
                right = pivot - 1;
                continue;
            }
        }
        return false;
    }
}
// @lc code=end

