public class Solution {
    public boolean wordPattern(String pattern, String str) {
        if (pattern.length() == 0 || str.length()==0) {
            return false;
        }
        
        String[] store = str.split(" ");
        int l = store.length;
        if (pattern.length() != l) {
            return false;
        }
        HashMap<String,String> map = new HashMap<String,String>();
        for(int i=0;i<l;i++) {
            String tmp = pattern.substring(i,i+1);
            if (map.containsKey(tmp)) {
                if ( !map.get(tmp).equals(store[i]) ) {
                    return false;
                }
            } else {
                if (map.containsValue(store[i])) {
                    return false;
                } else {
                    map.put(tmp,store[i]);
                }
            }
        }
        return true;
    } 
}