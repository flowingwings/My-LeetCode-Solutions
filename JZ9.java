// https://www.nowcoder.com/practice/9b4c81a02cd34f76be2659fa0d54342a

import java.util.ArrayList;
class Solution9 {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> ans = new ArrayList<>();
        int m = matrix.length;
        if(m==0){
            return ans;
        }
        int n = matrix[0].length;
        if(n==0){
            return ans;
        }
        boolean[][] visited = new boolean[m][n];
        int[][] dir = {
            {0,1},
            {1,0},
            {0,-1},
            {-1,0}
        };
        // int i=0;
        int x=0, y=0;
        int vec=0;
        boolean walkable = true;
        while(true){
            ans.add(matrix[x][y]);
            // i++;
            visited[x][y]=true;
            walkable = false;
            for(int j=0; j<4; j++){
                int newx = x+dir[vec][0], newy = y+dir[vec][1];
                if(newx >= 0 && newx < m && newy >= 0 && newy < n && !visited[newx][newy]){
                    walkable = true;
                    x=newx; y=newy;
                    break;
                }
                vec = (vec+1) % 4;
            }
            if(!walkable){
                break;
            }
        }
        return ans;
    }
}