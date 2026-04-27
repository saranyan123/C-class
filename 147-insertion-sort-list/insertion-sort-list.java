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
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;

        // Dummy node acts as the start of the sorted list
        ListNode dummy = new ListNode(0);
        ListNode curr = head;

        while (curr != null) {
            // At each iteration, we save the next node to process
            ListNode nextNode = curr.next;

            // Find the position in the sorted list to insert 'curr'
            // We always start searching from the dummy head
            ListNode prev = dummy;
            while (prev.next != null && prev.next.val < curr.val) {
                prev = prev.next;
            }

            // Insert 'curr' between 'prev' and 'prev.next'
            curr.next = prev.next;
            prev.next = curr;

            // Move to the next node in the original unsorted list
            curr = nextNode;
        }

        return dummy.next;
    }
}
