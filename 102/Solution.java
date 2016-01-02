/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public class data {
        TreeNode n;
        int level;
        public data(TreeNode node, int l) {
            n = node;
            level = l;
        }
    }
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<data> queue = new LinkedList<data>();
        List<List<Integer>> r = new ArrayList<List<Integer>>();
        if (root==null) return r;
        data d = new data(root,0);
        int cur = 0;
        queue.add(d);
        List<Integer> curl = new ArrayList<Integer>();
        while(!queue.isEmpty()){
            data tmp = queue.poll();
            if (tmp.level == cur) {
                curl.add(tmp.n.val);
            } else {
                r.add(curl);
                cur++;
                curl = new ArrayList<Integer>();
                curl.add(tmp.n.val);
            }
            if (tmp.n.left!=null) {
                data dd = new data(tmp.n.left,tmp.level+1);
                queue.add(dd);
            }
            if (tmp.n.right!=null) {
                data dd = new data(tmp.n.right,tmp.level+1);
                queue.add(dd);
            }
            
        }
        r.add(curl);
        return r;
        
    }
}