public class Solution {
    public int myAtoi(String str) {
        if (str.length()==0) return 0;
        
        int i=0;
        for (;i<str.length();i++) {
            if (str.charAt(i)==' ') continue;
            else break;
        }
        if (i==str.length()) return 0;
        int start = i;
        for(i = start+1;i<str.length();i++) {
            if ( !(str.charAt(i)>='0' && str.charAt(i)<='9') ){
                break;
            }
        }
        int end = i;
        String base = str.substring(start,end);
        if ( !( base.charAt(0)=='-' || base.charAt(0)=='+' || (base.charAt(0)>='0'&&base.charAt(0)<='9') )  ){
            return 0;
        }
        boolean flag = false;
        int l = 0;
        if (base.charAt(0)=='-') {
            flag = true;
            base = base.substring(1);
        } else if (base.charAt(0)=='+') {
            base = base.substring(1);
        }
        l = base.length();
        if (l>10) {
            return (flag)?-2147483648:2147483647; 
        }
        long r = 0;
        for(i=0;i<l;i++) {
            r=(base.charAt(i)-'0')+r*10;
        }
        if (flag) {
            if (-r<-2147483648) return -2147483648;
            else return (int)(-r);
        } else {
            if (r>2147483647) return 2147483647;
            else return (int)(r);
        }
        
        
        
        
    }
}