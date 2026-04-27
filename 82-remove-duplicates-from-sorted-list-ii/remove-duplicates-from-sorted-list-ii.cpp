
class Solution {
public:
    ListNode* deleteDuplicates(ListNode* head) {
        // Dummy node points to the head to simplify edge cases
        ListNode* dummy = new ListNode(0, head);
        ListNode* prev = dummy; 
        
        while (head != nullptr) {
            // If it's the start of a duplicate sequence
            if (head->next != nullptr && head->val == head->next->val) {
                // Move head to the end of the duplicate sequence
                while (head->next != nullptr && head->val == head->next->val) {
                    head = head->next;
                }
                // Skip all duplicates by linking prev to the node AFTER the sequence
                prev->next = head->next;
            } else {
                // No duplicate found, move prev forward
                prev = prev->next;
            }
            // Move head forward
            head = head->next;
        }
        
        ListNode* result = dummy->next;
        delete dummy; // Clean up memory
        return result;
    }
};
