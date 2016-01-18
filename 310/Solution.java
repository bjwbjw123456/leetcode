public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n==1) {
            List<Integer> rr = new ArrayList<Integer>();
            rr.add(0);
            return rr;
        }
        
        HashMap<Integer,List<Integer>> map = new HashMap<Integer,List<Integer>>();
        for(int j=0;j<edges.length;j++){
            int[] tmp = edges[j];
            for (int i=0;i<2;i++) {
                int key = tmp[i];
                List<Integer> list;
                if (map.containsKey(key)) {
                    list = map.get(key);
                } else {
                    list = new ArrayList<Integer>();
                }
                list.add(tmp[1-i]);
                map.put(key,list);
            }
        }
        List<Integer> todelete = new ArrayList<Integer>();
            
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            if (entry.getValue().size()==1) todelete.add(entry.getKey());
        }
            
        while(map.size()>2){
            List<Integer> next = new ArrayList<Integer>();
                
            for(int i=0;i<todelete.size();i++) {
                int key = todelete.get(i);
                Integer neibor = map.get(key).get(0);
                map.remove(key);
                List<Integer> ll = map.get(neibor);
                ll.remove(new Integer(key));
                if (ll.size()==1) next.add(neibor);
                map.put(neibor,ll);
            }
            todelete = next;
        }
        List<Integer> r = new ArrayList<Integer>(map.keySet());
        return r;
    }
}