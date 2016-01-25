/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head==null || head.next==null || head.next.next==null) return head;
        
        ListNode fake = new ListNode(-1);
        fake.next = head;
        
        ListNode even = head.next;
        
        ListNode oddc  = head;
        ListNode evenc = head.next;
        
        while(oddc.next!=null && oddc.next.next!=null && evenc.next!=null && evenc.next.next!=null) {
            oddc.next = evenc.next;
            evenc.next = evenc.next.next;
            oddc = oddc.next;
            evenc = evenc.next;
        }
        
        if (oddc.next!=null && oddc.next.next!=null) {
            oddc.next = oddc.next.next;
            oddc = oddc.next;
        }
        
        evenc.next = null;
        oddc.next = even;
        return fake.next;
    }
}