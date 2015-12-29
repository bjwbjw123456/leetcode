public class Solution {
    private void helper(int left,int right,List<String> r, String s){
        if (left == 0 && right ==0) {
            r.add(s);
            return;
        }
        if (left>0) {
            helper(left-1,right,r,s+"(");
        }
        if (right>left) {
            helper(left,right-1,r,s+")");
        }
    }
    
    public List<String> generateParenthesis(int n) {
        List<String> r = new ArrayList<String>();
        if (n==0) return r;
        if (n==1) {
            r.add("()");
            return r;
        }
        helper(n,n,r,"");
        return r;
        
    }
}