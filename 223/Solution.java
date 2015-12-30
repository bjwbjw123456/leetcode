public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int a = (A>E)?A:E;
        int b = (B>F)?B:F;
        int c = (C<G)?C:G;
        int d = (D<H)?D:H;
        int dd;
        if (a>=c || b>=d) dd =  0;
        else dd = (c-a)*(d-b);
        
        return (C-A)*(D-B) + (G-E)*(H-F) - dd;
        
    }
}