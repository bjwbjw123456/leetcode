public class Solution {
    public int titleToNumber(String s) {
        int l = s.length();
        int base = 26;
        int sum = 0;
        for (int i = 0; i <l;i++) {
            char tmp = s.charAt(i);
            int p = (int)(Math.pow( (double)base, (double)(l-1-i) ) ); 
            sum += p * (int)( (int)(tmp) - (int)('A') + 1 );
        }
        return sum;
        
    }
}