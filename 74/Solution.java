public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0;
        int j = n-1;
        while( i>=0&&i<m&&j>=0&&j<n ) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] < target ) {
                i++;
            } else {
                while(true) {
                    if (matrix[i][j] == target) {
                        return true;
                    }
                    j--;
                    if (j<0) return false;
                }
                
            }
            
        }
        return false;
        
    }
}