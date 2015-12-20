/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fake = new ListNode(-1);
        ListNode r = new ListNode(head.val);
        r.next = null;
        fake.next = r;
        head = head.next;
        while (head != null){
            ListNode cur = fake.next;
            ListNode pre = fake;
            for(;cur!=null;pre = cur,cur = cur.next) {
                if (head.val <= cur.val) {
                    ListNode tmp = new ListNode(head.val);
                    pre.next = tmp;
                    pre.next.next = cur;
                    break;
                }
                if (cur.next == null) {
                    ListNode tmp = new ListNode(head.val);
                    cur.next = tmp;
                    break;
                }
            }
            head = head.next;
        }
        return fake.next;
        
    }
}