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
    private int helper(TreeNode n, int x) {
        if (n == null) {
            return 0;
        }
        if (n.left == null && n.right == null) {
            return (x*10+n.val);
        }
        return helper(n.left,x*10+n.val) + helper(n.right,x*10+n.val);
        
    }
    
    
    public int sumNumbers(TreeNode root) {
        //Depth First Search
        if (root == null) {
            return 0;
        }
        if (root.left == null & root.right == null) {
            return root.val;
        }
        
        int l = helper(root.left,root.val);
        int r = helper(root.right,root.val);
        return l+r;
    }
    
    
}