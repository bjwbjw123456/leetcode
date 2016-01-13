public class Solution {
    public String numberToWords(int num) {
        
        if (num ==0) return "Zero";
        String[] base = {"Thousand","Million","Billion"}; 
        String[] number = {"One","Two","Three","Four","Five","Six","Seven","Eight","Nine"};
        String[] number20 = {"Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        String[] number10 = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        
        int i=0;
        String r ="";
        while(num>0) {
            int rest = num%1000;
            num = num/1000;
            String tmp = ""; 
            if (rest==0) {
                i++;
                continue;
            }
            if (rest!=0) {
                int h = rest/100;
                int th = (rest/10)%10;
                int in = rest%10;
                if (h!=0){
                    tmp = tmp + number[h-1] + " Hundred";
                } 
                if (th>=2) {
                    tmp = tmp + ((tmp.length()==0)?"":" ") + number20[th-2];
                    if (in!=0) tmp = tmp+" "+number[in-1];
                } else if (th==1) {
                    tmp = tmp + ((tmp.length()==0)?"":" ") + number10[in];
                } else {
                    if (in!=0) tmp = tmp + ((tmp.length()==0)?"":" ") + number[in-1];
                }
            }
            if (i==0) {
                r = tmp;
            } else {
                r = tmp + " " + base[i-1] + ((r.length()==0)?"":" ") +r;
            }
            
            i++;
        }
        return r;
    }
}