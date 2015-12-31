public class Solution {
    public String longestCommonPrefix(String[] strs) {
        String r = "";
        if (strs==null || strs.length==0){
            return r;
        }
        r= strs[0];
        for(int i=0;i<strs.length;i++) {
            int l1 = r.length();
            int l2 = strs[i].length();
            int j = 0;
            while(j<l1 && j<l2) {
                if (r.charAt(j)!=strs[i].charAt(j)){
                    break;
                }
                j++;
            }
            r = r.substring(0,j);
            if (r.length()==0) return r;
        }
        return r;
    }
}