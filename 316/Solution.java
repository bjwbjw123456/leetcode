public class Solution {
    public String removeDuplicateLetters(String s) {
        if (s.length() <= 1) {
            return s;
        }
        
        Stack stack = new Stack();
        
        int[] counts = new int[26];
        boolean[] in = new boolean[26];
        for (int i=0;i<26;i++) {
            counts[i] = 0;
            in[i] = false;
        }
        
        for(int i=0;i<s.length();i++) {
            char tmp = s.charAt(i);
            counts[tmp-'a']++;
        }
        
        for(int i=0;i<s.length();i++) {
            char tmp = s.charAt(i);
            counts[tmp-'a']--;
            if (in[tmp-'a']) continue;
            while( !stack.empty()  ){
                char peek = stack.peek().toString().charAt(0);
                if (counts[peek-'a'] == 0 || peek<tmp) break;
                in[peek-'a'] = false;
                stack.pop();
            }
            stack.push(tmp);
            in[tmp-'a'] = true;
        }
        String r = "";
        while(!stack.empty()){
            r = stack.peek().toString() + r;
            stack.pop();
        }
        
        return r;
        
    }
}