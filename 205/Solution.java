public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length()==0) {
            return true;
        }
        HashMap<String,String> map = new HashMap<String,String>();
        
        for(int i=0;i<s.length();i++) {
            String tmp = s.substring(i,i+1);
            if (map.containsKey(tmp)) {
                if (!map.get(tmp).equals(t.substring(i,i+1))) {
                    return false;
                }
            } else {
                if (map.containsValue(t.substring(i,i+1))) return false;
                map.put(tmp,t.substring(i,i+1));
            }
        }
        return true;
    }
}