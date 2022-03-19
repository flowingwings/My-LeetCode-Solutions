/*
 * @lc app=leetcode id=74 lang=java
 *
 * [74] Search a 2D Matrix
 */

// @lc code=start

// Binary search.
// Another solution: binary search first element of every row 
// to find the only row that probably contains target, 
// then binary search in that row.
// Would that be faster?
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
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

