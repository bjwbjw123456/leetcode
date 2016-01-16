public class Solution {
    private List<Integer> next(List<Integer> cur) {
        List<Integer> r = new ArrayList<Integer>();
        if (cur.size()==0) {
            r.add(1);
            return r;
        }
        if (cur.size()==1) {
            r.add(1);
            r.add(1);
            return r;
        }
        r.add(1);
        for (int i=0;i<cur.size()-1;i++) {
            r.add(cur.get(i)+cur.get(i+1));
        }
        r.add(1);
        return r;
    }
    
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> r = new ArrayList<List<Integer>>();
        List<Integer> cur = new ArrayList<Integer>();
        for(int i=0;i<numRows;i++) {
            cur = next(cur);
            r.add(cur);
        }
        return r;
    }
}