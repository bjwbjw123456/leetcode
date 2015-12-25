/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        int l = 1;
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        ListNode base = head;
        
        for(;head.next!=null;head = head.next){
            l++;
        }
        int step = k%l;
        if (step == 0) {
            return base;
        }
        head.next = base; //make it a circle;
        step = l-step;
        ListNode tmp = base;
        for (int i =1;i<step;i++) {
            tmp = tmp.next;
        }
        ListNode r = tmp.next;
        tmp.next = null;
        return r;
    }
}