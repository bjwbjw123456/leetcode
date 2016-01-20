public class Solution {
    private boolean isValid(String num, int i, int j) {
        String a = num.substring(0,i);
        String b = num.substring(i,i+j);
        if (a.charAt(0)=='0' && a.length()>1) {
            return false;
        }
        if (b.charAt(0)=='0' && b.length()>1) {
            return false;
        }
        Long a1 = Long.parseLong(a);
        Long b1 = Long.parseLong(b);
        String sum = "";
        
        for(int k=i+j;k!=num.length();k+=sum.length()){
            Long tmp = a1+b1;
            sum  = tmp.toString();
            a1 = b1;
            b1 = tmp;
            if (!num.startsWith(sum,k)) return false;
        }
        return true;
    }
    
    public boolean isAdditiveNumber(String num) {
        if (num.length()<3) return false;
        int l = num.length();
        //i and j are both length
        for (int i=1;i*2<l;i++){
            for (int j=1;j+i<=l-i;j++) {
                if (isValid(num,i,j)){
                    return true;
                }
            }
        }
        return false;
    }
}