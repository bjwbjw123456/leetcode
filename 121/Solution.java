public class Solution {
    public int maxProfit(int[] prices) {
        if (prices==null || prices.length<1) return 0;
        int[] dp = new int[prices.length];
        for (int i=0;i<prices.length;i++) {
            dp[i] = 0;
        }
        int max = 0;
        for (int i=1;i<prices.length;i++) {
            int tmp = dp[i-1]+prices[i]-prices[i-1];
            dp[i] = (tmp<0)?0:tmp;
            max = (dp[i]>max)?dp[i]:max;
        }
        return max;
    }
}