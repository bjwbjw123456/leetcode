public class NumMatrix {
    int[][] data;

    public NumMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            data = null;
            return;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        data = new int[m+1][n+1];
        for (int i = 0;i<m+1;i++) {
            data[i][0] = 0;
        }
        for (int j = 0;j<n+1;j++) {
            data[0][j] = 0;
        }
        for (int i=1;i<m+1;i++) {
            for (int j=1;j<n+1;j++) {
                data[i][j] = matrix[i-1][j-1]+data[i-1][j]+data[i][j-1]-data[i-1][j-1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (data==null) return 0;
        return data[row2+1][col2+1] - data[row2+1][col1] - data[row1][col2+1] + data[row1][col1];
    }
}


// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.sumRegion(1, 2, 3, 4);