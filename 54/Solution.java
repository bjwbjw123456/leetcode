public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> r = new ArrayList<Integer>();
        if (matrix==null || matrix.length==0 || matrix[0].length==0) return  r;
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        int turn = Math.min(m,n)/2;
        //System.out.println(turn);
        
        for(int cur=0;cur<turn;cur++) {
            for (int i=cur;i<n-cur-1;i++) {
                r.add(matrix[cur][i]);
            }
            for (int i=cur;i<m-cur-1;i++) {
                r.add(matrix[i][n-cur-1]);
            }
            for (int i=cur;i<n-cur-1;i++) {
                r.add(matrix[m-cur-1][n-1-i]);
            }
            for (int i=cur;i<m-cur-1;i++) {
                r.add(matrix[m-1-i][cur]);
            }
        }
        
        if (m<=n && m%2==1) {
            for (int i= m/2 ;i<n-m/2;i++) {
                r.add(matrix[m/2][i]);
            }
        }
        
        if (m>n && n%2==1) {
            for(int i=n/2;i<m-n/2;i++) {
                r.add(matrix[i][n/2]);
            }
        }
        return r;
    }
}