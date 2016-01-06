public class Solution {
    public int reverse(int x) {
        long ori = x;
        long res = 0;
        
        if (x==Integer.MIN_VALUE) return 0;
        
        if(ori<0) return 0-reverse(-x);
        
        while(res<=Integer.MAX_VALUE && res>=Integer.MIN_VALUE && ori>0) {
            res = res*10+(ori%10);
            ori = ori/10;
        }
        return (res<=Integer.MAX_VALUE && res>=Integer.MIN_VALUE)?(int)res:0;
    }
}