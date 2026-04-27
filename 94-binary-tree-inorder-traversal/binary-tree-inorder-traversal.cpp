/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    vector<int> inorderTraversal(TreeNode* root) {
        vector<int> result;
        stack<TreeNode*> st;
        TreeNode* curr = root;

        while (curr != nullptr || !st.empty()) {
            // 1. Reach the leftmost node of the current subtree
            while (curr != nullptr) {
                st.push(curr);
                curr = curr->left;
            }

            // 2. Process the top node (the "Root" in L-R-R)
            curr = st.top();
            st.pop();
            result.push_back(curr->val);

            // 3. Move to the right subtree
            curr = curr->right;
        }

        return result;
    }
};
