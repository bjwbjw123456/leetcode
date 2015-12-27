public class Solution {
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) return null; 
        int l = digits.length;
        int c = 1;
        for (int i = l-1; i>=0;i--) {
            int tmp = digits[i] + c;
            if (tmp >= 10) {
                tmp -= 10;
                c = 1;
            } else {
                c = 0;
            }
            digits[i] = tmp;
        }
        if (c == 0) return digits;
        int[] r = new int[l+1];
        r[0] = 1;
        for (int i=0;i<l;i++) {
            r[i+1] = digits[i];
        }
        return r;
        
    }
}