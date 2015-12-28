/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB==null) {
            return null;
        }
        ListNode h1 = headA;
        ListNode h2 = headB;
        ListNode tailA = headA;
        ListNode tailB = headB;
        while(tailA.next!=null) tailA = tailA.next;
        while(tailB.next!=null) tailB = tailB.next;
        if (tailA!=tailB) return null;
        
        tailA.next = h1;
        
        ListNode slow = headB;
        ListNode fast = headB;
        while(fast.next!=null && fast.next.next!=null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        slow = headB;
        while(slow!=fast) {
            slow=slow.next;
            fast=fast.next;
        }
        tailB.next = null;
        return slow;
        
    }
}