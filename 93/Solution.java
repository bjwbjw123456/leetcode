public class Solution {
    private boolean check(String ip) {
        if (ip.charAt(0)=='0') return (ip.length()==1);
        if (ip.length()>3) return false;
        if (Integer.parseInt(ip) <= 255) return true;
        else return false;
    }
    
    public List<String> restoreIpAddresses(String s) {
        List<String> r = new ArrayList<String>();
        if (s.length()>12 || s.length()<4) return r;
        int l = s.length();
        
        for(int i=0;i<l-3;i++) {
            for(int j=i+1;j<l-2;j++) {
                for (int k=j+1;k<l-1;k++) {
                    String part1 = s.substring(0,i+1);
                    String part2 = s.substring(i+1,j+1);
                    String part3 = s.substring(j+1,k+1);
                    String part4 = s.substring(k+1);
                    if (check(part1) && check(part2) && check(part3) && check(part4)) {
                        r.add(""+part1+"."+part2+"."+part3+"."+part4);
                    }
                }
                
            }
            
        }
        return r;
    }
}