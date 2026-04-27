class Solution {
public:
    int numDecodings(string s) {
        if (s.empty() || s[0] == '0') return 0;
        
        int n = s.length();
        // dp[i] stores the number of ways to decode the prefix s[0...i-1]
        vector<int> dp(n + 1, 0);
        
        // Base cases
        dp[0] = 1; // Empty string has 1 way
        dp[1] = 1; // Single non-zero digit has 1 way
        
        for (int i = 2; i <= n; i++) {
            // Check if single-digit decode is possible (s[i-1])
            if (s[i-1] != '0') {
                dp[i] += dp[i-1];
            }
            
            // Check if two-digit decode is possible (s[i-2]s[i-1])
            int twoDigit = stoi(s.substr(i-2, 2));
            if (twoDigit >= 10 && twoDigit <= 26) {
                dp[i] += dp[i-2];
            }
        }
        
        return dp[n];
    }
};
