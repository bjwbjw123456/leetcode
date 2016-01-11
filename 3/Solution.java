public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = s.length();
        if(l<=1) return l;
        
        int[] index = new int[256];
        for(int i=0;i<256;i++) {
            index[i] = -1;
        }
        
        int max = 0;
        int cur = 0;
        
        for(int i=0;i<l;i++){
            char tmp = s.charAt(i);
            if (index[tmp]!=-1){
                cur = Math.max(index[tmp]+1,cur);
            }
            index[tmp] = i;
            max = Math.max(i-cur+1,max);
        }
        return max;
    }
}