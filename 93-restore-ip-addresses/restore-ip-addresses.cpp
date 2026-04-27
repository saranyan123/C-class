class Solution {
public:
    void backtrack(string& s, int start, int dots, string current, vector<string>& result) {
        // Base Case: If we have 4 segments and reached the end of the string
        if (dots == 4) {
            if (start == s.length()) {
                current.pop_back(); // Remove the trailing dot
                result.push_back(current);
            }
            return;
        }

        // Optimization: Remaining string too long or too short for remaining dots
        int remainingChars = s.length() - start;
        int remainingDots = 4 - dots;
        if (remainingChars < remainingDots || remainingChars > remainingDots * 3) {
            return;
        }

        // Try lengths 1, 2, and 3 for the current segment
        for (int len = 1; len <= 3 && start + len <= s.length(); len++) {
            string segment = s.substr(start, len);
            int val = stoi(segment);

            // Validity Check:
            // 1. Value <= 255
            // 2. No leading zeros (if len > 1, first char cannot be '0')
            if (val <= 255 && (len == 1 || segment[0] != '0')) {
                backtrack(s, start + len, dots + 1, current + segment + ".", result);
            }
        }
    }

    vector<string> restoreIpAddresses(string s) {
        vector<string> result;
        if (s.length() < 4 || s.length() > 12) return result;
        backtrack(s, 0, 0, "", result);
        return result;
    }
};
