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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode l3 = dummy;
        int carry = 0;
        while(l1 != null || l2 != null || carry != 0){
            int a = (l1 != null) ? l1.val : 0;
            int b = (l2 != null) ? l2.val : 0;
            int val = a + b + carry;
            carry = val / 10; //either 1 or 0
            l3.next = new ListNode(val % 10); // 1-9
            l3 = l3.next;

            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }
        return dummy.next;
    }
}
