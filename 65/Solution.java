public class Solution {
    public boolean isNumber(String s) {
        s = s.trim();
        if (s.length()==0) return false;
        if (s.length()==1) {
            if (s.charAt(0)>'9' || s.charAt(0)<'0') return false;
        }
        int i=0;
        if (s.charAt(0)=='-' || s.charAt(0)=='+') {
            i=1;
        }
        boolean point = false;
        boolean e = false;
        boolean digit = false;
        
        for (;i<s.length();i++) {
            char tmp = s.charAt(i);
            if (tmp>='0'&&tmp<='9') {
                digit = true;
                continue;
            }
            if (tmp=='.') {
                if (point || e) return false;
                else point = true;
                //if (i==s.length()-1) return false;
                //if (s.charAt(i-1)>'9' || s.charAt(i-1)<'0') return false;
                //if (i>0 && (s.charAt(i-1) == 'e')) return false;
                continue;
            }
            if (tmp == 'e') {
                if (e) return false;
                else e = true;
                if (i==0 || i==s.length()-1 || (!digit)) return false;
                //if ( !((s.charAt(i-1)<='9' && s.charAt(i-1)>='0')||s.charAt(i-1)=='.') ) return false;
                if (i<s.length()-1 && (s.charAt(i+1)=='-' || s.charAt(i+1)=='+' ) ) {
                    i++;
                    if (i==s.length()-1) return false;
                }
                continue;
            }
            return false;
        }
        if (!digit) return false;
        return true;
    }
}