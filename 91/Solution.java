public class Solution {
    public int numDecodings(String s) {
        int l = s.length();
        if (l==0) return l;
        if (s.charAt(0)=='0') return 0;
        if (l==1) return 1;
        int[] dp = new int[l+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2;i<=l;i++) {
            if (s.charAt(i-2) > '2' || ( s.charAt(i-2)=='2'&&s.charAt(i-1)>'6' ) || s.charAt(i-2) == '0'){
                if(s.charAt(i-1)=='0') dp[i] = 0;
                else dp[i] = dp[i-1];
            } else {
                if(s.charAt(i-1)=='0') {
                    if (s.charAt(i-2)=='0') dp[i] = 0;
                    else dp[i] = dp[i-2];
                } else dp[i] = dp[i-1]+dp[i-2];
            }
        }
        
        return dp[l];
    }
}