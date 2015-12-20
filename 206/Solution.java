/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode fake = new ListNode(-1);
        fake.next = head;
        if (head == null || head.next==null) {
            return head;
        }
        
        ListNode cur = fake.next;
        ListNode next = cur.next;
        cur.next = null;
        while(next!=null) {
            fake.next = new ListNode(next.val);
            fake.next.next = cur;
            cur = fake.next;
            next = next.next;
        }
        return fake.next;
        
    }
}