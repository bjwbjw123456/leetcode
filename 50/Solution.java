public class Solution {
    public double myPow(double x, int n) {
        if (n==0) return 1;
        if (x==(double)(1)) return 1;
        if (x==(double)(-1)) {
            if (n%2==0) return 1;
            else return -1;
        }
        if (x==0) return 0;
        if (x<0) {
            if (n%2==0) return myPow(-x,n);
            else return 0-myPow(-x,n);
        }
        
        if (n<0){
            return (double)(1)/myPow(x,-n);
        }
        
        double r = 1;
        while(n>0){
            int cur = 1;
            double tmp = x;
            while(n>cur && n-cur>cur) {
                tmp = tmp*tmp;
                cur*=2;
            }
            n-=cur;
            r*=tmp;
        }
        return r;
    }
}