public class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int answer[][] = new int[m][n];
        for (int i =0;i<m;i++) {
            for (int j=0;j<n;j++) {
                answer[i][j] = 0;
            }
        }
        answer[0][0] = grid[0][0];
        for (int i = 1;i<m;i++) {
            answer[i][0] = answer[i-1][0] + grid[i][0];
        }
        for (int j = 1; j<n;j++) {
            answer[0][j] = answer[0][j-1] + grid[0][j];
        }
        
        for (int i = 1; i<m; i++) {
            for (int j = 1;j<n;j++) {
                int t1 = answer[i-1][j];
                int t2 = answer[i][j-1];
                
                answer[i][j] = (t1<t2)?t1:t2;
                answer[i][j] += grid[i][j];
            }
        }
        return answer[m-1][n-1];
        
        
    }
}