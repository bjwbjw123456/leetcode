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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> r = new ArrayList<List<Integer>>();
        if (root == null) return r;
        
        Stack<TreeNode> stack1 = new Stack<TreeNode>();
        Stack<TreeNode> stack2 = new Stack<TreeNode>();
        
        boolean isLeft = true;
        stack1.push(root);
        
        while((!stack1.isEmpty())||(!stack2.isEmpty())){
            Stack<TreeNode> source = (isLeft)?stack1:stack2;
            Stack<TreeNode> target = (isLeft)?stack2:stack1;
            
            List<Integer> ll = new ArrayList<Integer>();
            while(!source.isEmpty()){
                TreeNode tmp = source.peek();
                ll.add(tmp.val);
                source.pop();
                if(isLeft) {
                    if (tmp.left!=null) {
                        target.push(tmp.left);
                    }
                    if (tmp.right!=null) {
                        target.push(tmp.right); 
                    }
                } else {
                    if (tmp.right!=null) {
                        target.push(tmp.right); 
                    }
                    if (tmp.left!=null) {
                        target.push(tmp.left);
                    }
                }
            }
            r.add(ll);
            isLeft = !isLeft;
        }
        return r;
    }
}