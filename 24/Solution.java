/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fake = new ListNode(-1);
        fake.next = head;
        ListNode pre = fake;
        ListNode a = head;
        ListNode b = head.next;
        ListNode next = b.next;
        while (true) {
            pre.next = b;
            b.next = a;
            a.next = next;
            pre = a;
            a = next;
            if (a==null) {
                break;
            }
            b = a.next;
            if (b==null) {
                break;
            }
            next = b.next;
        }
        return fake.next;
    }
}