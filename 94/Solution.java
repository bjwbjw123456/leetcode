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
    List<Integer> list;
    
    private void helper(TreeNode root) {
        if(root==null) return;
        helper(root.left);
        list.add(root.val);
        helper(root.right);
    }
    
    public List<Integer> inorderTraversal(TreeNode root) {
        list = new ArrayList<Integer>();
        helper(root);
        return list;
    }
}