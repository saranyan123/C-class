/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        // Step 1: Create a new node for each original node and 
        // insert it between the original node and its next node.
        // Original: A -> B -> C
        // Interweaved: A -> A' -> B -> B' -> C -> C'
        Node curr = head;
        while (curr != null) {
            Node newNode = new Node(curr.val);
            newNode.next = curr.next;
            curr.next = newNode;
            curr = newNode.next;
        }

        // Step 2: Set the random pointers for the copied nodes.
        // If original node A has random pointing to C, then A' random should point to C'.
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        // Step 3: Separate the interweaved list into the original and the copied list.
        Node newHead = head.next;
        Node currOld = head;
        Node currNew = newHead;

        while (currOld != null) {
            currOld.next = currOld.next.next;
            if (currNew.next != null) {
                currNew.next = currNew.next.next;
            }
            currOld = currOld.next;
            currNew = currNew.next;
        }

        return newHead;
    }
}
