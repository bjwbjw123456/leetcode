public class Solution {
    public int maxProfit(int[] prices) {
        if (prices==null || prices.length<=1) return 0;
        int[] sells = new int[prices.length];
        int[] buys = new int[prices.length];
        sells[0] = 0;
        buys[0] = -prices[0];
        buys[1] = -prices[1];
        sells[1] = Math.max(buys[0]+sells[1], sells[0]+prices[1]-prices[0]);
        int r = Math.max(sells[0],sells[1]);
        
        for(int i=2;i<prices.length;i++) {
            sells[i] = Math.max(buys[i-1]+prices[i], sells[i-1]+prices[i]-prices[i-1]);
            buys[i] = Math.max(sells[i-2]-prices[i], buys[i-1]+prices[i-1]-prices[i]);
            r = Math.max(r,sells[i]);
        }
        return r;
    }
}