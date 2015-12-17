public class Solution {
    private String multi(String n, int x) {
        int l = n.length();
        int c = 0;
        String r = "";
        for (int i = 0; i< l; i++) {
            char t = n.charAt(l-1-i);
            int tt = (int)( (int)(t)-(int)('0') );
            int tr = tt*x + c;
            if (tr >= 10) {
                c = tr/10;
                tr = tr%10;
            } else {
                c = 0;
            }
            r = String.valueOf( (char)( (int)(tr) + (int)('0') ) )+r;
        }
        if (c > 0) {
            r = String.valueOf( (char)( (int)(c) + (int)('0') ) )+r;
        }
        return r;
    }
    
    private String add(String a, String b) {
        int l1 = a.length();
        int l2 = b.length();
        if (l1 > l2) {
            return add(b,a);
        }
        // now l1 is less or equal to l2
        int c = 0;
        String sum = "";
        for (int i = 0; i<l2;i++) {
            char c1;
            if (i>=l1) {
                c1 = '0'; 
            } else {
                c1 = a.charAt(l1-i-1);
            }
            char c2 = b.charAt(l2-i-1);
            int x1 = (int)(c1) - (int)('0');
            int x2 = (int)(c2) - (int)('0');
            int r = x1 + x2 + c;
            if (r >= 10) {
                c = 1;
                r-=10;
            }else {
                c = 0;
            }
            sum = String.valueOf((char)( r+(int)('0') )) + sum;
        }
        if (c == 1) {
            sum = "1" + sum;
        }
        
        return sum;
    }
    
    public String multiply(String num1, String num2) {
        int l1 = num1.length();
        int l2 = num2.length();
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        
        if (l1 > l2) {
            return multiply(num2,num1);
        }
        
        String sum = "";
        
        for (int i = 0; i<l1;i++) {
            int m = (int)(num1.charAt(l1-1-i)) - (int)('0');
            String tmp = multi(num2,m);
            System.out.println(tmp);
            for (int j = 0; j<i;j++) {
                tmp += "0";
            }
            sum = add(sum,tmp);
        }
        return sum;
    }
    
}