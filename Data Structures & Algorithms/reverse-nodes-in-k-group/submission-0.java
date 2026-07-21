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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0, head);
        ListNode groupPrev = dummy;              // the node just BEFORE the current group
        while (true) {
            // 1. find the k-th node of this group; bail if fewer than k remain
            ListNode kth = groupPrev;
            for (int i = 0; i < k; i++) {
                kth = kth.next;
                if (kth == null) return dummy.next;   // "leave as-is" case
            }
            
            ListNode groupNext = kth.next;       // first node of the NEXT group
            // 2. reverse this group in place: nodes (groupPrev.next .. kth)
            ListNode prev = groupNext;           // <-- the clever part
            ListNode curr = groupPrev.next;
            while (curr != groupNext) {
                ListNode tmp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = tmp;
            }
            
            // 3. reconnect and advance
            ListNode oldFirst = groupPrev.next;  // was the group's head, now its tail
            groupPrev.next = kth;                // kth is the group's new head
            groupPrev = oldFirst;                // move anchor to the tail for the next group
        }
    }
}
