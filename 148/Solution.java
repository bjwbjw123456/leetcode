/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    private ListNode findMid(ListNode n) {
        if (n == null) {
            return null;
        }
        if (n.next == null) {
            return n;
        }
        if (n.next.next == null) {
            return n;
        }
        
        ListNode slow = n;
        ListNode fast = n;
        
        while(fast.next!=null && fast.next.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
        
    }
    
    private ListNode merge(ListNode a, ListNode b) {
        ListNode fake = new ListNode(-1);
        ListNode r = fake;
        while(a!=null && b!=null) {
            ListNode tmp;
            if (a.val < b.val) {
                tmp = new ListNode(a.val);
                a = a.next;
            } else {
                tmp = new ListNode(b.val);
                b = b.next;
            }
            fake.next = tmp;
            fake = fake.next;
        }
        if (a != null) {
            fake.next = a;
        }
        if (b != null) {
            fake.next = b;
        }
        return r.next;
    }
    
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        if (head.next.next == null) {
            int t1 = head.val;
            int t2 = head.next.val;
            if (t1 > t2) {
                head.val = t2;
                head.next.val = t1;
            }
            return head;
        }
        ListNode mid = findMid(head);
        ListNode second = mid.next;
        mid.next = null;
        
        
        return merge(sortList(head),sortList(second));
        
        
    }
}