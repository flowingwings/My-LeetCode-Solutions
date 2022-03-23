/*
 * @lc app=leetcode id=79 lang=java
 *
 * [79] Word Search
 */

// @lc code=start
class Solution {
    
    static int[][] dir = {
        {0,1},{0,-1},{1,0},{-1,0}
    };
    boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        visited = new boolean[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(dfs(board, visited, word, 0, i, j, m, n)){
                    return true;
                }
            }
        }
        return false;
    }


    public boolean dfs(char[][] board, boolean[][] visited, String word, int pos, int row, int col, int m, int n){
        if(board[row][col] != word.charAt(pos)){
            return false;
        }
        if(pos == word.length() - 1){
            return true;
        }
        visited[row][col] = true;
        for(int i=0; i<4; i++){
            int newRow = row+dir[i][0];
            int newCol = col+dir[i][1];
            if(newRow >= 0 && newRow < m 
            && newCol >= 0 && newCol < n 
            && !visited[newRow][newCol]
            && dfs(board, visited, word, pos+1, newRow, newCol, m, n)){
                return true;
            }
        }
        visited[row][col] = false;
        return false;
    }
}
// @lc code=end

