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
        ListNode nextNode = new ListNode();
        // stores the final linked list
        ListNode finalSum = nextNode;

        int sum, value;
        int carry = 0;
        // continue looping until the carry is 0, and all lists have been fully traversed
        while (l1 != null || l2 != null || carry != 0) {
            // sum = l1.val + l2.val + carry (ignore l1 or l2 if null)
            // traverse l1 and l2 to next node for next iteration
            sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            } 
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            // calculate carry and value to add to linked list 
            carry = sum / 10;
            value = sum - (carry * 10);
        
            // store the value in the last element in the linked list
            nextNode.val = value;

            if (l1 != null || l2 != null || carry != 0) {
                // only add another node if another iteration will occur
                ListNode newNode = new ListNode();
                nextNode.next = newNode;
                nextNode = newNode;
            }
        }

        return finalSum;
    }
}