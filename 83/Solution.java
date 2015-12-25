/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        int base = head.val;
        ListNode r = head;
        ListNode pre = head;
        ListNode cur = head.next;
        while (cur!=null) {
            if (cur.val==base){
                pre.next = cur.next;
                cur = cur.next;
            } else {
                base = cur.val;
                pre = cur;
                cur = cur.next;
            }
        }
        return r;
    }
}