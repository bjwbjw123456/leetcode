/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        if (node.neighbors.size()==0) return new UndirectedGraphNode(node.label);
        
        LinkedList<UndirectedGraphNode> list = new LinkedList<UndirectedGraphNode>();
        HashMap<Integer,UndirectedGraphNode> map = new HashMap<Integer,UndirectedGraphNode>();
        
        UndirectedGraphNode r = new UndirectedGraphNode(node.label);
        map.put(r.label,r);
        list.addFirst(node);
        
        while(!list.isEmpty()){
            UndirectedGraphNode cur = list.pollLast();
            UndirectedGraphNode newnode = map.get(cur.label);
            for(UndirectedGraphNode nn:cur.neighbors){
                if( map.containsKey(nn.label) ) {
                    newnode.neighbors.add(map.get(nn.label));
                } else {
                    UndirectedGraphNode tmp = new UndirectedGraphNode(nn.label);
                    newnode.neighbors.add(tmp);
                    map.put(nn.label,tmp);
                    list.addFirst(nn);
                }
            }
        }
        return r;
    }
}