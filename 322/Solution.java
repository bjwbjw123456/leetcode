public class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        if (coins==null) return -1;
        //if (amount == 0) return 1;
        if (coins.length ==0) return -1;
        
        dp[0] = 0;
        for(int i=1;i<=amount;i++) {
            dp[i] = amount+1;
        }
        
        for(int i=0;i<coins.length;i++) {
            for(int j=coins[i];j<=amount;j++) {
                dp[j] = Math.min(dp[j],dp[j-coins[i]]+1);
            }
        }
        return (dp[amount]==amount+1)?-1:dp[amount];
    }
}