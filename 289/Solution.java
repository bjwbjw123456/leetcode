public class Solution {
    private int judge(int[][] board, int i, int j) {
        int m= board.length;
        int n = board[0].length;
        if(i<0 || i>=m || j<0 || j>=n) return 0;
        else return (board[i][j]%2);
    }
    
    private int count(int[][] board, int i, int j){
        int m = board.length;
        int n = board[0].length;
        return judge(board,i-1,j-1)+judge(board,i-1,j)+judge(board,i-1,j+1)
                + judge(board,i,j-1) + judge(board,i,j+1) 
                +judge(board,i+1,j-1)+judge(board,i+1,j)+judge(board,i+1,j+1);
    }
    
    
    public void gameOfLife(int[][] board) {
        if (board==null || board.length==0 || board[0].length==0) return;
        int m = board.length;
        int n = board[0].length;
        for(int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                int tmp = count(board,i,j);
                if (board[i][j]==1) {
                    if (tmp<2) board[i][j] = 3;
                    else if (tmp>3) board[i][j] = 3;
                    else continue;
                } else {
                    if(tmp == 3) board[i][j] = 2;
                }
            }
        }
        
        for (int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if (board[i][j]==0 || board[i][j]==1) continue;
                board[i][j] = 1-(board[i][j]%2);
            }
        }
        return;
    }
}