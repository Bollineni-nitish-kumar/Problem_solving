/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val-b.val);
        for(ListNode ln : lists){
            if(ln == null){
                continue;
            }
            pq.add(ln);
        }

        ListNode head = null;
        ListNode curr = null;
        while(!pq.isEmpty()){
           ListNode ln = pq.poll();
           ListNode firstNode = ln;
           ln= ln.next;
           firstNode.next = null;
           if(head == null){
                head = firstNode;
                curr=head;   
           }else{
            curr.next=firstNode;
            curr = curr.next;
           }
           if(ln !=null){
             pq.add(ln);
           }
        }

        return head;
    }
}
