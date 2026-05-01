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
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode prev = dummy;
        while (prev.next != null && prev.next.next != null) {
            // only continue if there is another adjacent pair to swap
            ListNode first = prev.next;
            ListNode second = first.next;
            ListNode next = second.next;

            // swap pointers
            prev.next = second;
            first.next = next;
            second.next = first;
            
            // change prev for next adjacent pair
            prev = first;
        }

        return dummy.next; // this points to the new head
    }
}