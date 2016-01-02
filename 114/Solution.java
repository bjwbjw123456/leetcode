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
    private TreeNode helper(TreeNode n)  {
        if (n==null) return null;
        if (n.left==null && n.right==null) return n;
        if (n.left==null && n.right!=null) {
            return helper(n.right);
        }
        if (n.left!=null && n.right==null) {
            TreeNode tmp = helper(n.left);
            n.right = n.left;
            n.left = null;
            return tmp;
        }
        TreeNode tmp = helper(n.left);
        TreeNode tmp2 = helper(n.right);
        TreeNode orir = n.right;
        n.right = n.left;
        n.left = null;
        tmp.right = orir;
        return tmp2;
    }
    
    public void flatten(TreeNode root) {
        if (root==null) return;
        helper(root);
        return;
    }
}