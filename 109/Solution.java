/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return (new TreeNode(head.val));
        
        ListNode fake = new ListNode(-1);
        fake.next = head;
        
        ListNode fast = head;
        ListNode slow = head;
        ListNode pre = fake;
        
        while(fast.next!=null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            pre = pre.next;
        }
        
        TreeNode root = new TreeNode(slow.val);
        pre.next = null;
        root.left = sortedListToBST(fake.next);
        root.right = sortedListToBST(slow.next);
        return root;
    }
}