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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder==null || inorder.length==0) return null;
        if (inorder.length==1) return new TreeNode(inorder[0]);
        int base = postorder[postorder.length-1];
        int i = 0;
        for (;i<inorder.length;i++) {
            if (inorder[i] == base) break;
        }
        int[] linorder = new int[i];
        int[] lpostorder = new int[i];
        int[] rinorder = new int[inorder.length-i-1];
        int[] rpostorder = new int[inorder.length-i-1];
        
        for (int j=0;j<i;j++){
            linorder[j] = inorder[j];
            lpostorder[j] = postorder[j];
        }
        
        for(int j=0;j<inorder.length-i-1;j++) {
            rinorder[j] = inorder[i+j+1];
            rpostorder[j] = postorder[i+j];
        }
        
        TreeNode r = new TreeNode(postorder[postorder.length-1]);
        r.left = buildTree(linorder,lpostorder);
        r.right = buildTree(rinorder,rpostorder);
        return r;
        
    }
}