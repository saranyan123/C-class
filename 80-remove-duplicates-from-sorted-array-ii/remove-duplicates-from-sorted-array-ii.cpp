class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        int n = nums.size();
        if (n <= 2) return n; // If 2 or fewer elements, no need to process

        int k = 2; // Start from the third element (index 2)
        for (int i = 2; i < n; i++) {
            // Compare current element with the element two positions back in the 'new' array
            if (nums[i] != nums[k - 2]) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }
};
