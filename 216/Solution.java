public class Solution {
    List<List<Integer>> r;
    
    private void helper (int start, int count, int target, List<Integer> cur, int k) {
        if (k==0) {
            if (count==target) r.add(cur);
            return;
        }
        for(int i=start;i<10;i++) {
            if (i>target-count) return;
            
            List<Integer> tmp = new ArrayList<Integer>(cur);
            tmp.add(i);
            helper(i+1,count+i,target,tmp,k-1);
        }
        return;
    }
    
    
    public List<List<Integer>> combinationSum3(int k, int n) {
        r = new ArrayList<List<Integer>>();
        List<Integer> cur = new ArrayList<Integer>();
        helper(1,0,n,cur,k);
        return r;
    }
}