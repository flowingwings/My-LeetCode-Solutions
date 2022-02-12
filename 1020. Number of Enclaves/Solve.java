import java.util.Arrays;

class Solve{
    public static void main(String[] args) {
        int[][] grid = {{0,0,0,0}, {1,0,1,0}, {0,1,1,0}, {0,0,0,0}};
        Solution1 solution = new Solution1();
        System.out.println(solution.numEnclaves(grid));
    }
}

class Solution1 {
    public int numEnclaves(int[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        boolean[][] able = new boolean[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                visited[i][j] = false;
                able[i][j] = false;
            }
        }
        for(int i=0; i<m; i++){
            if(i == 0 || i == m-1){
                for(int j=0; j<n; j++){
                    able[i][j] = true && (grid[i][j] == 1);
                    // This && substatement took me about 10 min to figure out.
                    // But considering I was watching a stream then, it could have been much faster.
                }
            }
            else{
                able[i][0] = true && (grid[i][0] == 1);
                able[i][n-1] = true && (grid[i][n-1] == 1);
            }
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1 && able[i][j] && !visited[i][j]){
                    dfs(grid, visited, able, i, j, m, n);
                }
            }
        }
        int ans = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1 && !able[i][j]){
                    ans ++;
                }
            }
        }
        return ans;
    }
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};
    void dfs(int[][] grid, boolean[][] visited, boolean[][] able, int x, int y, int m, int n){
        visited[x][y] = true;
        for(int i=0; i<4; i++){
            int newx = x + dx[i];
            int newy = y + dy[i];
            if(
                newx < 0 || newy < 0 || newx >= m || newy >= n || 
                grid[newx][newy] == 0 || visited[newx][newy]
                ){
                continue;
            }
            able[newx][newy] = true;
            // for(int j=0; j<m; i++){
            //     System.out.println(Arrays.toString(visited[j]));
            // }
            // System.out.println("\n");
            
            // for(int j=0; j<m; i++){
            //     System.out.println(Arrays.toString(able[j]));
            // }
            // System.out.println(able);
            // System.out.println("\n\n");
            dfs(grid, visited, able, newx, newy, m, n);
        }
        return;
    }
    
}

class Solution2{
    public int numEnclaves(int[][] grid){
        // Removed array able, because it's unecessary.
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                visited[i][j] = false;
            }
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1 && !visited[i][j] &&
                 (i == 0 || i == m - 1 || j == 0 || j == n - 1)){
                    dfs(grid, visited, i, j, m, n);
                }
            }
        }
        int ans = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1 && !visited[i][j]){
                    ans ++;
                }
            }
        }
        return ans;
    }
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};
    void dfs(int[][] grid, boolean[][] visited, int x, int y, int m, int n){
        visited[x][y] = true;
        for(int i=0; i<4; i++){
            int newx = x + dx[i];
            int newy = y + dy[i];
            if(
                newx < 0 || newy < 0 || newx >= m || newy >= n || 
                grid[newx][newy] == 0 || visited[newx][newy]
                ){
                continue;
            }
            dfs(grid, visited, newx, newy, m, n);
        }
        return;
    }
}