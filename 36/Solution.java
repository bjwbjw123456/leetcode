public class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<9;i++) {
            int[] flag = new int[9];
            for (int j=0;j<9;j++) {
                char tmp = board[i][j];
                if (tmp == '.') continue;
                if (flag[tmp-'1']==1) return false;
                else flag[tmp-'1']=1;
            }
        }
        for (int j=0;j<9;j++) {
            int [] flag = new int[9];
            for (int i=0;i<9;i++) {
                char tmp = board[i][j];
                if (tmp == '.') continue;
                if (flag[tmp-'1']==1) return false;
                else flag[tmp-'1'] = 1;
            }
        }
        
        for (int k=0;k<9;k++) {
            int [] flag = new int[9];
            for (int i=0;i<3;i++) {
                for (int j=0;j<3;j++) {
                    char tmp = board[i+(k*3/9)*3][j+(k*3)%9];
                    if (tmp == '.') continue;
                    if (flag[tmp-'1']==1) return false;
                    else flag[tmp-'1'] = 1;
                }
            }
        }
        return true;
    }
}