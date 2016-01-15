public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] r = new int[n][n];
        if (n==0) return r;
        int turn = n/2;
        int count = 1;
        for (int cur=0;cur<turn;cur++){
            for (int i=cur;i<n-cur-1;i++) {
                r[cur][i] = count;
                count++;
            }
            for (int i=cur;i<n-cur-1;i++) {
                r[i][n-cur-1] = count;
                count++;
            }
            for (int i=cur;i<n-cur-1;i++) {
                r[n-cur-1][n-1-i] = count;
                count++;
            }
            for (int i=cur;i<n-cur-1;i++) {
                r[n-1-i][cur] = count;
                count++;
            }
        }
        if (n%2==1) {
            r[n/2][n/2] = n*n;
        }
        return r;
    }
}