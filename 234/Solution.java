/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    private boolean helper(ListNode n,ListNode faker) {
        if (n == null) {
            return true;
        }
        if (!helper(n.next,faker)) {
            return false;
        }
        if (n.val != faker.next.val) {
            return false;
        }
        faker.next = faker.next.next;
        return true;
    }
    
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode faker = new ListNode(-1);
        faker.next = head;
        return helper(head,faker);
    }
}