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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) return null;
        if (preorder.length == 1) return new TreeNode(preorder[0]);
        int base = preorder[0];
        int i=0;
        for(;i<inorder.length;i++) {
            if (inorder[i] == base) break;
        }
        int[] inleft = new int[i];
        int[] preleft = new int[i];
        for (int j=0;j<i;j++) {
            inleft[j] = inorder[j];
        }
        for (int j=0;j<i;j++) {
            preleft[j] = preorder[j+1];
        }
        
        int[] inright = new int[inorder.length-i-1];
        int[] preright = new int[inorder.length-i-1];
        for (int j=0;j<inorder.length-i-1;j++) {
            inright[j] = inorder[j+i+1];
        }
        for (int j=0;j<inorder.length-i-1;j++) {
            preright[j] = preorder[j+i+1];
        }
        TreeNode r = new TreeNode(preorder[0]);
        r.left = buildTree(preleft,inleft);
        r.right = buildTree(preright,inright);
        return r;
        
    }
}