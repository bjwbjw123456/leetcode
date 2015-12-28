/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        if (head.next == null) {
            if (head.val == val) return null;
            else return head;
        }
        ListNode fake = new ListNode(-1);
        fake.next = head;
        ListNode pre = fake;
        ListNode cur = head;
        ListNode next = head.next;
        
        while(cur!=null) {
            if (cur.val!=val) {
                pre = cur;
                cur=cur.next;
                continue;
            }
            pre.next = cur.next;
            cur = cur.next;
        }
        return fake.next;
        
    }
}