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
        // place a node at the beginning to make operations easier 
        ListNode dummyNode = new ListNode(-1, head);
        ListNode currentNode = dummyNode;
        ListNode delayedNode = dummyNode;

        // iterate through to find the correct node 
        for (int x = 0; x < n; x++) {
            if (currentNode != null) {
                currentNode = currentNode.next;
            } else {
                return head;
            }
        }

        while (currentNode.next != null) {
            currentNode = currentNode.next;
            delayedNode = delayedNode.next;
        } 

        delayedNode.next = delayedNode.next.next;

        return dummyNode.next;
    }
}