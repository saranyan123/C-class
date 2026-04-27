class Solution {
public:
    void backtrack(vector<int>& nums, int start, vector<int>& current, vector<vector<int>>& result) {
        // Add the current subset to our result
        result.push_back(current);

        for (int i = start; i < nums.size(); i++) {
            // If the current element is the same as the previous one, skip it
            // i > start ensures we don't skip the first occurrence in a new branch
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }

            // Include the number
            current.push_back(nums[i]);
            // Move to the next element
            backtrack(nums, i + 1, current, result);
            // Backtrack: remove the number to try other possibilities
            current.pop_back();
        }
    }

    vector<vector<int>> subsetsWithDup(vector<int>& nums) {
        vector<vector<int>> result;
        vector<int> current;
        // Sort is essential to group duplicates together
        sort(nums.begin(), nums.end());
        backtrack(nums, 0, current, result);
        return result;
    }
};
