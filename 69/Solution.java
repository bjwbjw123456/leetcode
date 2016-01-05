public class Solution {
    private long helper(long l,long h,long x){
        System.out.println(l+":"+h);
        if (l==h) return l;
        long middle = l+(h-l)/2;
        if(middle*middle==x || (middle*middle<x)&&((middle+1)*(middle+1)>x) ) return middle;
        if(middle*middle<x) return helper(middle+1,h,x);
        else return helper(l,middle,x);
    }
    
    public int mySqrt(int x) {
        if (x<=1) return x; 
        if (x>1000000) {
            return (int)helper(1,(long)(x/1000),(long)x);
        } else {
            return (int)helper(1,(long)x,(long)x);
        }
    }
}