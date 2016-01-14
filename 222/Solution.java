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
    
    private int leftDepth(TreeNode n){
        TreeNode cur = n;
        int depth = 0;
        while(cur!=null) {
            cur = cur.left;
            depth++;
        }
        return depth;
    }
    
    private int rightDepth(TreeNode n) {
        TreeNode cur = n;
        int depth = 0;
        while(cur!=null) {
            cur = cur.right;
            depth++;
        }
        return depth;
    }
    
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int count = 0;
        int l = leftDepth(root);
        int r = rightDepth(root);
        if (l==r) return (2<<(l-1))-1;
        else return 1+countNodes(root.left)+countNodes(root.right);
    }
}