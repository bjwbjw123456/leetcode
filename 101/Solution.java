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
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return helper(root.left,root.right);
        
        
    }
    
    private boolean helper(TreeNode l, TreeNode r) {
        if (l==null && r == null) {
            return true;
        }
        if ( (l==null && r!=null)||(r==null && l!=null) ) {
            return false;
        }
        if (l.val == r.val) {
            return ( helper(l.left,r.right) && helper(l.right,r.left) );
        } else {
            return false;
        }
            
    }
    
}


http://www.acmerblog.com/symmetric-treeleetcode-6185.html