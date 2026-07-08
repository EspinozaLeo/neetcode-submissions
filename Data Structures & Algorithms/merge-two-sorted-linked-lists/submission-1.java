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
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        ListNode curr1 = list1, curr2 = list2;
        while(curr1 != null && curr2 != null){
            if(curr1.val <= curr2.val){
                tail.next = curr1;
                curr1 = curr1.next;
            } else{
                tail.next = curr2;
                curr2 = curr2.next;
            }
            tail = tail.next;
        }
        tail.next = (curr1 != null) ? curr1 : curr2;
        return dummy.next;
    }
}