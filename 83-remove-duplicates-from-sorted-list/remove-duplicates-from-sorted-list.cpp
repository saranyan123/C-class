class Solution {
public:
    ListNode* deleteDuplicates(ListNode* head) {
        // Start from the head of the list
        ListNode* current = head;

        // Traverse until the end or the second-to-last node
        while (current != nullptr && current->next != nullptr) {
            // Check if the current value matches the next value
            if (current->val == current->next->val) {
                // Save the node to delete to free memory
                ListNode* temp = current->next;
                // Skip the next node
                current->next = current->next->next;
                delete temp; 
            } else {
                // If they don't match, just move to the next node
                current = current->next;
            }
        }
        
        return head;
    }
};