public class Solution {
    private int min(int a,int b,int c) {
        int t = (a<b)?a:b;
        return (t<c)?t:c;
    }
    public int nthUglyNumber(int n) {
        List<Integer> l2 = new ArrayList<Integer>();
        List<Integer> l3 = new ArrayList<Integer>();
        List<Integer> l5 = new ArrayList<Integer>();
        l2.add(1);
        l3.add(1);
        l5.add(1);
        int r = 0;
        
        for (int i=1;i<=n;i++) {
            r = min(l2.get(0),l3.get(0),l5.get(0));
            if (r == l2.get(0)) l2.remove(0);
            if (r == l3.get(0)) l3.remove(0);
            if (r == l5.get(0)) l5.remove(0);
            l2.add(r*2);
            l3.add(r*3);
            l5.add(r*5);
        }
        return r;
        
    }
}