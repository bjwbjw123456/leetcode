public class Solution {
    private int compute(int a,int b, char op){
        switch(op){
            case '+': return a+b;
            case '-': return a-b;
            case '*': return a*b;
            case '/': return a/b;
        }
        return 0;
    }
    
    
    public List<Integer> diffWaysToCompute(String input) {
        int val = 0;
        int index = 0;
        List<Integer> r = new ArrayList<Integer>();
        if (input.length()==0) return r;
        
        for(;index<input.length();index++) {
            char tmp = input.charAt(index);
            if (tmp>='0' && tmp<='9') {
                val = val*10+(tmp-'0');
            } else {
                break;
            }
        }
        
        if(index == input.length()) {
            r.add(val);
            return r;
        }
        
        
        for(int i=0;i<input.length();i++) {
            char tmp = input.charAt(i);
            if (! (tmp>='0' && tmp<='9') ) {
                List<Integer> left = diffWaysToCompute(input.substring(0,i));
                List<Integer> right = diffWaysToCompute(input.substring(i+1,input.length()));
                for(int j=0;j<left.size();j++) {
                    for (int k=0;k<right.size();k++) {
                        r.add(compute(left.get(j),right.get(k),tmp));
                    }
                }
            }
        }
        
        return r;
    }
}