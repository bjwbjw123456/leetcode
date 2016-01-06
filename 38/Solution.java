public class Solution {
    private String helper(String x) {
        char cur = x.charAt(0);
        int count = 1;
        String r = "";
        
        for (int i=1;i<x.length();i++) {
            char tmp = x.charAt(i);
            if (tmp == cur) {
                count++;
            } else {
                r = r+count;
                r = r+cur;
                cur = tmp;
                count = 1;
            }
        }
        r = r+count+cur;
        return r;
    }
    
    public String countAndSay(int n) {
        if (n==0) return "";
        String r = "1";
        for (int i=1;i<n;i++) {
            r = helper(r);
        }
        return r;
    }
}