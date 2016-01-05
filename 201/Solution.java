public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        if (m==n) return n;
        int bits = 0;
        while(m!=n){
            m = m>>1;
            n = n>>1;
            bits++;
        }
        return m<<bits;
    }
}