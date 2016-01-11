public class Solution {
    public boolean isScramble(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();
        if (l1!=l2) return false;
        
        boolean[][][] dp = new boolean[l1][l2][l1+1];
        
        for(int i=l1-1;i>=0;i--) {
            for(int j=l2-1;j>=0;j--){
                for(int k=0;k<=l1-Math.max(i,j);k++) {
                    if( s1.substring(i,i+k).equals(s2.substring(j,j+k)) ) {
                        dp[i][j][k] = true;
                        continue;
                    }
                    for(int l=1;l<k;l++) {
                        if ( (dp[i][j][l] && dp[i+l][j+l][k-l]) || (dp[i][j+k-l][l] && dp[i+l][j][k-l]) ){
                            dp[i][j][k] = true;
                            break;
                        }
                    }
                }
            }
        }
        return dp[0][0][l1];
    }
}