public class Solution {
    public boolean isMatch(String s, String p) {
        if (p.length()==0) return (s.length()==0);
        int ls = s.length();
        int lp = p.length();
        
        boolean[][] dp = new boolean[ls+1][lp+1];
        dp[0][0] = true;
        for (int i=1;i<=ls;i++) {
            dp[i][0] = false;
        }
        
        for (int i=0;i<=ls;i++) {
            for (int j=1;j<=lp;j++) {
                char tmp = p.charAt(j-1);
                if (tmp!='*'){
                    if (i==0) {
                        dp[i][j] = false;
                    } else {
                        dp[i][j] = dp[i-1][j-1] && (tmp=='?' || tmp == s.charAt(i-1));
                    }
                } else {
                    if (i==0) {
                        dp[i][j] = dp[i][j-1];
                    } else {
                        dp[i][j] = dp[i][j-1] || dp[i-1][j-1] || dp[i-1][j];
                    }
                }
            }
        }
        return dp[ls][lp];
    }
}