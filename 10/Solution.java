public class Solution {
    public boolean isMatch(String s, String p) {
        if (p.length()==0) return (s.length()==0);
        
        if (p.length()<2 || p.charAt(1)!='*'){
            if (s.length()==0) return false;
            
            if (p.charAt(0)=='.' || p.charAt(0)==s.charAt(0))  {
                return isMatch(s.substring(1),p.substring(1));
            } else {
                return false;
            }
        } else {
            char tmp = p.charAt(0);
            while(s.length()!=0 && (s.charAt(0)==tmp || tmp=='.')) {
                if (isMatch(s,p.substring(2))) {
                    return true;
                }
                s = s.substring(1);
            }
            return isMatch(s,p.substring(2));
        }

    }
}