/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* partition(ListNode* head, int x) {
        // Dummy nodes to start two separate lists
        ListNode* lessHead = new ListNode(0);
        ListNode* greaterHead = new ListNode(0);
        
        // Pointers to track the current end of both lists
        ListNode* less = lessHead;
        ListNode* greater = greaterHead;
        
        while (head != nullptr) {
            if (head->val < x) {
                less->next = head;
                less = less->next;
            } else {
                greater->next = head;
                greater = greater->next;
            }
            head = head->next;
        }
        
        // Important: Terminate the 'greater' list to avoid cycles
        greater->next = nullptr;
        
        // Connect the 'less' list to the 'greater' list
        less->next = greaterHead->next;
        
        // The real head is the node after our dummy 'lessHead'
        ListNode* result = lessHead->next;
        
        // Clean up dummy nodes
        delete lessHead;
        delete greaterHead;
        
        return result;
    }
};
