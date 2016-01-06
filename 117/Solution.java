/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root==null) return;
        TreeLinkNode outer;
        if (root.left!=null && root.right!=null) {
            root.left.next = root.right;
            outer = root.right;
        } else if (root.left==null && root.right!=null) {
            outer = root.right;
        } else if (root.left!=null && root.right==null) {
            outer = root.left;
        } else {
            return;
        }
        TreeLinkNode base = root;
        while(base.next!=null) {
            base = base.next;
            if (base.left!=null) {
                outer.next = base.left;
                break;
            } else if (base.right != null){
                outer.next = base.right;
                break;
            }
        }
        
        //right first
        connect(root.right);
        connect(root.left);
    }
}