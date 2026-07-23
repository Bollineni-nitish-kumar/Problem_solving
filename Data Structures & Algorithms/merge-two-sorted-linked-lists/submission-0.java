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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        ListNode resultHead = null;
        ListNode temp = null;

        while(list1!=null && list2!=null){
            int l1Val = list1.val;
            int l2Val = list2.val;

            if(l1Val <= l2Val){
                if(resultHead == null){
                    resultHead = list1;
                    temp = list1;
                }else{
                    temp.next=list1;
                    temp = temp.next;
                }
                list1=list1.next;
            }else{
                if(resultHead == null){
                    resultHead = list2;
                    temp=list2;
                }else{
                    temp.next=list2;
                    temp = temp.next;
                }
                list2=list2.next;
            }

        }

        if(list1!=null){
            temp.next=list1;
        }

        if(list2!=null){
            temp.next = list2;
        }

        return resultHead;
        
    }
}