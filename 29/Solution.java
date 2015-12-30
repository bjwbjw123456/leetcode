public class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == 0 ) return 0;
        long d = dividend;
        long d2 = divisor;
        long r = 0;
        boolean flag = false;
        if ( d < 0 && d2>0 ) {
            flag = true;
            d = 0-d;
        } else if ( d > 0 && d2<0  ){
            flag = true;
            d2 = 0-d2;
        } else if (d<0){
            d = 0-d;
            d2 = 0-d2;
        }
        
        
        while (d>d2) {
            long base = 1;
            long tmp = d2;
            while(tmp<=d) {
                tmp = tmp<<1;
                base = base<<1;
            }
            tmp = tmp>>1;
            base = base>>1;
            
            
            d = d - tmp;
            r+=base;
        }
        if (d==d2) r++;
        r = (flag)?0-r:r;
        if (r > 2147483647) r--;
        return (int)r;
        
    }
}