/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode fake = new ListNode(-1);
        fake.next = head;
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast!=null) {
            slow = slow.next;
            if (fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            
            if (fast == slow) {
                break;
            }
        }
        if (fast!=slow) {
            return null;
        }
        slow = fake.next;
        while(fast!=slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}