public class Solution {
    public boolean isPalindrome(String s) {
        Stack stack = new Stack();
        String x = s.toUpperCase();
        if (s.length() == 0) {
            return true;
        }
        int l = s.length();
        int i = 0;
        int j = l-1;
        while (i<=j) {
            char a = x.charAt(i);
            if ( !( (a>='0'&&a<='9')||(a>='A'&&a<='Z') ) ) {
                i++;
                continue;
            }
            char b = x.charAt(j);
            if ( !( (b>='0'&&b<='9')||(b>='A'&&b<='Z') ) ) {
                j--;
                continue;
            }
            if (a!=b) {
                return false;
            }
            i++;
            j--;
        }
        return true;
        
    }
}