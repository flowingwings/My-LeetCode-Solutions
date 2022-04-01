// https://www.nowcoder.com/practice/abc3fe2ce8e146608e868a70efebf62e

class Solution4 {
    public boolean Find(int target, int [][] array) {
        int rowNum = array.length, colNum = array[0].length;
        int col_l = 0, col_r = colNum-1;
        int row_l = 0, row_r = rowNum-1;
        while(col_l <= col_r && row_l <= row_r
        && col_l >= 0 && col_r < colNum
        && row_l >= 0 && row_r < rowNum){
            if(array[row_r][col_l] == target || array[row_l][col_r] == target){
                return true;
            }
            if(row_l == row_r && col_l == col_r){
                return false;
            }
            while(row_r >= 0 && col_l < colNum && array[row_r][col_l] < target){
                col_l++;
            }
            while(row_l < rowNum && col_r >= 0 && array[row_l][col_r] > target){
                col_r--;
            }
            while(row_l < rowNum && col_r >= 0 && array[row_l][col_r] < target){
                row_l ++;
            }
            while(row_r >= 0 && col_l < colNum && array[row_r][col_l] > target){
                row_r --;
            }
        }
        return false;
    }
}