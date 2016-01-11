public class Solution {
    public String convertToTitle(int n) {
        String r = "";
        while(n>=27) {
            int rest = n%26;
            if (rest == 0) rest=26;
            rest--;
            r = ""+ (char)('A'+rest) +r;
            n = n/26;
            if(rest==25) n--;
        }
        if (n==0) n=26;
        n--;
        r = ""+(char)('A'+n)+r;
        return r;
    }
}