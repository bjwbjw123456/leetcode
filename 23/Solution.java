/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        int l = lists.length;
        ListNode fake = new ListNode(-1);
        ListNode cur = fake;
        boolean hasNode = true;
        PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(10,new Comparator<ListNode>(){
            @Override
            public int compare(ListNode n1, ListNode n2)
            {
                return n1.val-n2.val;
            }
        });
        for (int i=0;i<l;i++) {
            if (lists[i] == null) continue;
            heap.add(lists[i]);
        }
        
        while(heap.peek()!=null) {
            ListNode tmp = heap.poll();
            cur.next = new ListNode(tmp.val);
            cur = cur.next;
            if (tmp.next!=null) {
                heap.add(tmp.next);
            }
        }
        
        return fake.next;
    }
}