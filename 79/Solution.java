public class Solution {
    boolean[][] base;
    
    private boolean helper(char[][] board,int m,int n,int i,int j,String s){
        //System.out.println(s + ":" + i + ":" + j);
        if (s.length()==0) return true;
        if (i>=m || i<0 || j>=n || j<0) return false;
        if (base[i][j]) return false;
        if (board[i][j] != s.charAt(0)) {
            return false;
        }
        base[i][j] = true;
        
        boolean jj = helper(board,m,n,i-1,j,s.substring(1)) || helper(board,m,n,i+1,j,s.substring(1)) || helper(board,m,n,i,j-1,s.substring(1)) || helper(board,m,n,i,j+1,s.substring(1));
        
        if (!jj) {
            base[i][j] = false;
        }
        return jj;
    }
    
    
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0){
            return false;
        }
        if (word.length()==0) return true;
        int m = board.length;
        int n = board[0].length;
        base = new boolean[m][n];
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++) {
                base[i][j] = false;
            }
        }
        
        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                if (helper(board,m,n,i,j,word)){
                    return true;
                }
            }
        }
        return false;
        
    } 
}