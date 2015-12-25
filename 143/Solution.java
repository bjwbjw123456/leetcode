/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode fake = new ListNode(-1);
        fake.next = head;
        ListNode base = head;        
        Stack<ListNode> stack = new Stack<ListNode>();  
        int l = 0;
        for (;head!=null;head=head.next) {
            stack.push(head);
            l++;
        }
        head = base;
        ListNode cur = head;
        ListNode tail = fake;
        ListNode tmp;
        for (int i = 0; i<l/2;i++) {
            tail.next = cur;
            tmp = cur.next;
            cur.next = stack.pop();
            tail = tail.next.next;
            cur = tmp;
        }
        if (l%2!=0) {
            tail.next = stack.pop();
            tail = tail.next;
        }
        tail.next = null;
        
    }
}