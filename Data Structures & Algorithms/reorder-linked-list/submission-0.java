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
    public void reorderList(ListNode head) {
        if(head == null || head.next == null){
            return;
        }
        int len = findLength(head);
        int halfLength = len/2;
        if(len%2==1){
            halfLength = halfLength +1;
        }

        ListNode curr = head;
        ListNode temp =head.next;
        halfLength=halfLength-1;

        while(halfLength > 0){
            curr = curr.next;
            temp = temp.next;
            halfLength--;
        }

        curr.next = null;
        ListNode reversedPointer = reverseLinkedList(temp);

        ListNode pointer = head;

        while(pointer != null && reversedPointer != null){
            ListNode pointerAhead = pointer.next;
            ListNode reversedAhead = reversedPointer.next;

            // Connect first half node to second half node
            pointer.next = reversedPointer;
            // Connect second half node back to next first half node
            reversedPointer.next = pointerAhead;

            // Move pointers forward
            pointer = pointerAhead;
            reversedPointer = reversedAhead;

        }
        
    }


    private int findLength(ListNode head){
        int len =0;

        while(head != null){
            len++;
            head = head.next;
        }

        return len;
    }

    private ListNode reverseLinkedList(ListNode head){
        if(head == null){
            return null;
        }

        ListNode prev=head;
        ListNode curr = head.next;
        ListNode ahead = head.next;
        prev.next = null;
        while(ahead!=null){
            ahead = curr.next;
            curr.next=prev;
            prev=curr;
            curr = ahead;
        }

        return prev;
    }
}
