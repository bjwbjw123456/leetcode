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
        boolean print;
        public data(TreeNode treenode, boolean p) {
            n=treenode;
            print=p;
        }
        
    }
    
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> r = new ArrayList<Integer>();
        if(root==null) return r;
        Stack<data> stack = new Stack<data>();
        stack.push(new data(root,true));
        if (root.right!=null) {
            stack.push(new data(root.right,false));
        }
        if (root.left!=null) {
            stack.push(new data(root.left,false));
        }
        while(!stack.isEmpty()){
            data tmp = stack.peek();
            if (tmp.print) {
                r.add(tmp.n.val);
                stack.pop();
            } else {
                if (tmp.n.right!=null) {
                    stack.push(new data(tmp.n.right,false));
                }
                if (tmp.n.left!=null) {
                    stack.push(new data(tmp.n.left,false));
                }
                tmp.print = true;
            }
        }
        return r;
    }
}