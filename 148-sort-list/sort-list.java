class Solution {
    public ListNode sortList(ListNode head) {
        // Base case: if list is empty or has only one node
        if (head == null || head.next == null) return head;

        // 1. Split the list into two halves
        ListNode prev = null, slow = head, fast = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null; // Disconnect the two halves

        // 2. Recursively sort each half
        ListNode leftSide = sortList(head);
        ListNode rightSide = sortList(slow);

        // 3. Merge the sorted halves
        return merge(leftSide, rightSide);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }

        // Attach remaining nodes
        if (l1 != null) curr.next = l1;
        if (l2 != null) curr.next = l2;

        return dummy.next;
    }
}
