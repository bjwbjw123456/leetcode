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
    int count;
    int r;
    
    private void helper(TreeNode n){
        if (n==null) {
            return;
        }
        helper(n.left);
        count--;
        if (count==0) r = n.val;
        helper(n.right);
    } 
    
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        helper(root);
        return r;
    }
}