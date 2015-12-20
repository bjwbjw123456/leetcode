/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n == 0) {
            return head;
        }
        ListNode fake = new ListNode(-1);
        fake.next = head;
        ListNode pre = fake;
        ListNode slow = fake.next;
        ListNode fast = fake.next;
        for (int i=1; i<n;i++) {
            fast = fast.next;
        }
        while(fast.next!=null) {
            fast = fast.next;
            slow = slow.next;
            pre = pre.next;
        }
        pre.next = pre.next.next;
        return fake.next;
    }
}