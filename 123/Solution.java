public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length<=1) return 0;
        int[] profit1 = new int[prices.length];
        int[] profit2 = new int[prices.length];
        
        for(int i=0;i<prices.length;i++) {
            profit1[i] = 0;
            profit2[i] = 0;
        }
        
        int max = 0;
        int pre = 0;
        for(int i=1;i<prices.length;i++) {
            int tmp = pre+prices[i]-prices[i-1];
            pre = (tmp<0)?0:tmp;
            max = (tmp>max)?tmp:max;
            profit1[i] = max;
        }
        
        pre = 0;
        max = 0;
        for(int i=prices.length-2;i>=0;i--) {
            int tmp = pre+prices[i+1]-prices[i];
            pre = (tmp<0)?0:tmp;
            max = (tmp>max)?tmp:max;
            profit2[i] = max;
        }
        
        int r = 0;
        for(int i=0;i<prices.length;i++) {
            int tmp = profit1[i] + profit2[i];
            r = (tmp>r)?tmp:r;
        }
        return r;
    }
}