public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map= new HashMap<String,List<String>>();
        List<List<String>> r = new ArrayList<List<String>>();
        
        if (strs.length==0) return r;
        
        for(int i=0;i<strs.length;i++) {
            char[] arrays = strs[i].toCharArray();
            Arrays.sort(arrays);
            String tmp = String.copyValueOf(arrays);
            if(map.containsKey(tmp)) {
                List<String> list = map.get(tmp);
                list.add(strs[i]);
                map.put(tmp,list);
            } else {
                List<String> list = new ArrayList<String>();
                list.add(strs[i]);
                map.put(tmp,list);
            }
        }
        for (List<String> value : map.values()){
            Collections.sort(value);
            r.add(value);
        }
        return r;
    }
}