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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = findLen(head);
        int indxToRemove = len-n;

        if(indxToRemove == 0){
            return head.next;
        }
        ListNode prev = null;
        ListNode curr = head;
        ListNode ahead = null;

        int idx = 0;

        while(idx < indxToRemove){
            prev = curr;
            ahead = curr.next.next;
            curr = curr.next;
            idx++;
        }
        prev.next=ahead;
        return head;
    }

    private int findLen(ListNode head){
        int len=0;

        while(head!=null){
            len++;
            head=head.next;
        }
        return len;
    }
}
