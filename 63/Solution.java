public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) {
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] data = new int[m][n];
        
        for (int i =0;i<m;i++) {
            for (int j =0;j<n;j++) {
                data[i][j] = 0;
            }
        }
        
        for (int i =0;i<m;i++) {
            if (obstacleGrid[i][0] == 1) {
                break;
            }
            data[i][0] = 1;
        }
        
        for (int j =0;j<n;j++) {
            if (obstacleGrid[0][j] == 1) {
                break;
            }
            data[0][j] = 1;
        }
        
        for (int i =1;i<m;i++) {
            for (int j =1;j<n;j++) {
                if (obstacleGrid[i][j] == 1) {
                    data[i][j] = 0;
                } else {
                    data[i][j] = data[i-1][j] + data[i][j-1];
                }
            }
        }
        return data[m-1][n-1];
    }
}