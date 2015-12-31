public class Solution {
    public void rotate(int[][] matrix) {
        if(matrix==null || matrix.length<=1) return;
        int l = matrix.length;
        int k = l-1;
        
        int m = (l%2==0)?l/2:l/2+1;
        int n = (l%2==0)?l/2:l/2;
        
        
        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                int count = 0;
                int tmp = matrix[i][j];
                while(count<4) {
                    int old = matrix[j][k-i];
                    matrix[j][k-i] = tmp;
                    tmp = old;
                    int ti = i;
                    int tj = j;
                    i = tj;
                    j = k-ti;
                    count++;
                }
            }
        }
        
        
    }
}