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
    private boolean helper(TreeNode r,long min,long max) {
        //System.out.println(min+","+max);
        if (r == null) return true;
        if (min>max) return false;
        long base = r.val;
        if (base > max || base<min) return false;
        return helper(r.left,min,base-1) && helper(r.right,base+1,max);
    }
    
    public boolean isValidBST(TreeNode root) {
        long min = 	java.lang.Integer.MIN_VALUE;
        long max = 	java.lang.Integer.MAX_VALUE;
        return helper(root,min,max);
    }
}