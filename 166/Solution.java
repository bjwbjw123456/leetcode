public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        long a = (long)numerator;
        long b = (long)denominator;
        boolean flag = false;
        
        if (a<0&&b>0) {
            a = -a;
            flag = true;
        } else if (a>0&&b<0) {
            b = -b;
            flag = true;
        } else if (a<0&&b<0) {
            a = -a;
            b = -b;
        }
        
        
        int count = 0;
        
        long digit = a/b;
        long rest = a%b;
        
        String r = ""+digit;
        if (rest==0) return (flag)?"-"+r:r;
        
        Map<Long, Integer> map = new HashMap<Long, Integer>();
        int position = 0;
        
        String latter = "";
        
        while(rest!=0) {
            Long tmp = rest*10;
            if(map.containsKey(tmp)) {
                int pos = map.get(tmp);
                String tt = "";
                tt = tt + latter.substring(0,pos);
                tt = tt+"(";
                tt = tt + latter.substring(pos,position);
                tt = tt + ")";
                latter = tt;
                break;
            }
            map.put(tmp,position);
            position++;
            latter = latter+(tmp/b);
            rest = tmp%b;
        }
        r = r+"."+latter;
        if (flag) {
            r = "-"+r;
        }
        return r;
    }
}