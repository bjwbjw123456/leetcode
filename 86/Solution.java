/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        boolean flag = false;
        ListNode fake = new ListNode(-1);
        fake.next = head;
        ListNode pre = fake;
        ListNode anchor = fake;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val<x) {
                if (!flag) {
                    anchor = anchor.next;
                    pre  = cur;
                    cur = cur.next;
                    continue;
                } else {
                    pre.next = cur.next;
                    ListNode tmp = anchor.next;
                    anchor.next = cur;
                    cur.next = tmp;
                    cur = pre.next;
                    anchor = anchor.next;
                }
            } else {
                flag = true;
                pre = cur;
                cur = cur.next;
            }
        }
        return fake.next;
        
    }
}