public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length()!=t.length()) return false;
        
        int[] data = new int[26];
        for (int i=0;i<26;i++) {
            data[i] = 0;
        }
        for (int i =0;i<s.length();i++) {
            data[s.charAt(i)-'a']++;
        }
        
        for(int i=0;i<t.length();i++) {
            data[t.charAt(i)-'a']--;
            if (data[t.charAt(i)-'a']<0) return false;
        }
        return true;
        
        
    }
}