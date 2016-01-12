/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head==null) return null;
        if (head.next==null) {
            RandomListNode r = new RandomListNode(head.label);
            if (head.random==null) {
                r.random = null;
            } else {
                r.random = r;
            }
        }
        
        RandomListNode fake = new RandomListNode(-1);
        RandomListNode cur = head;
        
        while (cur!=null) {
            RandomListNode tmp = new RandomListNode(cur.label);
            RandomListNode next = cur.next;
            tmp.next = next;
            cur.next = tmp;
            cur = cur.next.next;
        }
        
        fake.next = head.next;
        
        cur = head;
        
        while(cur!=null) {
            if(cur.random==null) {
                cur.next.random = null;
            } else {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        
        cur = head;
        RandomListNode next = cur.next.next;
        
        while(cur!=null) {
            cur.next.next = (next==null)?null:next.next;
            cur.next = next;
            cur = next;
            if (cur==null) break;
            next = cur.next.next;
        }
        
        return fake.next;
        
    }
}