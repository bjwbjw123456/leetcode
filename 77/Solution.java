public class Solution {
    List<List<Integer>> r;
    public void helper(int start, int end, int k, List<Integer> cur){
        if (k>end-start+1) return;
        if (k==0) {
            r.add(cur);
            return;
        }
        if (k == end-start+1) {
            List<Integer> tmp = new ArrayList<Integer>(cur);
            for(int i=start;i<=end;i++) {
                tmp.add(i);
            }
            r.add(tmp);
            return;
        }
        for (int i=start;i<=end-k+1;i++) {
            List<Integer> tmp = new ArrayList<Integer>(cur);
            tmp.add(i);
            helper(i+1,end,k-1,tmp);
        }
        return;
    } 
    
    public List<List<Integer>> combine(int n, int k) {
        r = new ArrayList<List<Integer>>();
        List<Integer> cur = new ArrayList<Integer>();
        helper(1,n,k,cur);
        return r;
    }
}