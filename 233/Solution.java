public class Solution {
    public int countDigitOne(int n) {
        long count = 0;
        for (long m=1;m<=n;m*=10) {
            long a = n/m;
            long b = n%m;
            count += (a+8)/10 * m;
            count += (a%10==1)?(b+1):0;
        }
        return (int)count;
    }
}