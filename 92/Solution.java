/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null || m==n) {
            return head;
        }
        ListNode fake = new ListNode(-1);
        fake.next = head;
        ListNode pre = fake;
        for (int i = 1; i<m;i++) {
            pre = pre.next;
        }
        ListNode h = pre.next;
        ListNode cur = h.next;
        ListNode next = null;
        ListNode tail = h;
        tail.next = null;
        for (int i = m;i<n;i++) {
            next = cur.next;
            pre.next = cur;
            cur.next = h;
            h = pre.next;
            cur = next;
        }
        tail.next = next;
        return fake.next;
    }
}