#include <iostream>
#include <string>
#include <unordered_map>
#include <algorithm>

using namespace std;

class Solution {
    // Memoization table to store results of previously solved subproblems
    unordered_map<string, bool> memo;

public:
    bool isScramble(string s1, string s2) {
        // Base Case: Strings are identical
        if (s1 == s2) return true;
        
        // Base Case: Lengths are different (shouldn't happen per constraints) or 1
        if (s1.length() != s2.length()) return false;

        // Check memoization table
        string key = s1 + "_" + s2;
        if (memo.count(key)) return memo[key];

        // Pruning: If character counts don't match, they can't be scrambled
        string temp1 = s1, temp2 = s2;
        sort(temp1.begin(), temp1.end());
        sort(temp2.begin(), temp2.end());
        if (temp1 != temp2) return memo[key] = false;

        int n = s1.length();
        for (int i = 1; i < n; i++) {
            // Case 1: No swap at this level
            // Check if (s1_left, s2_left) AND (s1_right, s2_right) are scrambled
            if (isScramble(s1.substr(0, i), s2.substr(0, i)) && 
                isScramble(s1.substr(i), s2.substr(i))) {
                return memo[key] = true;
            }

            // Case 2: Swapped at this level
            // Check if (s1_left, s2_right) AND (s1_right, s2_left) are scrambled
            // s2_right starts from index (n-i)
            if (isScramble(s1.substr(0, i), s2.substr(n - i)) && 
                isScramble(s1.substr(i), s2.substr(0, n - i))) {
                return memo[key] = true;
            }
        }

        return memo[key] = false;
    }
};
