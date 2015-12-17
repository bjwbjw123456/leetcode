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
    private boolean helper(TreeNode n, int x, int sum) {
        if (n == null) {
            return false;
        }
        if (n.left == null && n.right == null) {
            return (x+n.val == sum);
             
        }
        return helper(n.left,x+n.val,sum) || helper(n.right,x+n.val,sum);
    }
    
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right==null ) {
            if (root.val == sum) {
                return true;
            } else {
                return false;
            }
        }
        
        return helper(root.left,root.val,sum) || helper(root.right,root.val,sum);
        
    }
}