class Solution {
public:
    vector<int> grayCode(int n) {
        vector<int> result;
        int numElements = 1 << n; // 2^n
        for (int i = 0; i < numElements; i++) {
            // Gray code formula: i XOR (i divided by 2)
            result.push_back(i ^ (i >> 1));
        }
        return result;
    }
};
