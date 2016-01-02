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
    private boolean helper(TreeNode root,TreeNode data) {
        if (root == null) {
            data.val = 0;
            return true;
        }
        TreeNode l = new TreeNode(-1);
        TreeNode r = new TreeNode(-1);
        boolean ll = helper(root.left,l);
        boolean rr = helper(root.right,r);
        data.val = Math.max(l.val,r.val)+1;
        if (!ll || !rr) return false;
        if (l.val-r.val>1 || l.val-r.val<-1) return false;
        return true;
    }
    
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        TreeNode data = new TreeNode(-1);
        return helper(root,data);
        
    }
}