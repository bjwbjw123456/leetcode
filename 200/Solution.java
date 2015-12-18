public class Solution {
    private void digging(int i, int j, char[][] grid, int m, int n) {
        if (i>=m || j>=n || i<0 || j<0) {
            return;
        }
        if (grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        digging(i+1,j,grid,m,n);
        digging(i,j+1,grid,m,n);
        digging(i-1,j,grid,m,n);
        digging(i,j-1,grid,m,n);
        return;
    }
    
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        
        for(int i = 0 ;i <m;i++) {
            for (int j = 0 ; j < n; j ++) {
                if (grid[i][j] == '0') {
                    continue;
                } else {
                    count++;
                    digging(i,j,grid,m,n);
                }
            }
        }
        return count;
    }
}