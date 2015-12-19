/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        
        ListNode r = new ListNode(0);
        ListNode back = r; 
        
        while (l1 != null) {
            int t1 = l1.val;
            int t2 = l2.val;
            if (t1<t2) {
                ListNode tmp = new ListNode(t1);
                l1 = l1.next;
                r.next = tmp;
            } else {
                ListNode tmp = new ListNode(t2);
                l2 = l2.next;
                r.next = tmp;
            }
            r = r.next;
            if (l2 == null) {
                break;
            }
        }
        
        while (l1 != null) {
            ListNode tmp = new ListNode(l1.val);
            l1 = l1.next;
            r.next = tmp;
            r = r.next;
        }
        while (l2 != null) {
            ListNode tmp = new ListNode(l2.val);
            l2 = l2.next;
            r.next = tmp;
            r = r.next;
        }
        return back.next;
        
        
    }
}