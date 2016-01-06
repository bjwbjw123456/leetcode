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
    private TreeNode helper(int[] nums,int head, int tail) {
        if (head>tail) return null;
        if(head==tail) return new TreeNode(nums[head]);
        int middle = head+(tail-head)/2;
        TreeNode root = new TreeNode(nums[middle]);
        root.left = helper(nums,head,middle-1);
        root.right = helper(nums,middle+1,tail);
        return root;
    }
    
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums==null) return null;
        return helper(nums,0,nums.length-1);
    }
}