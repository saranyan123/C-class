import java.util.*;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // Convert list to set for O(1) lookup
        Set<String> wordSet = new HashSet<>(wordDict);
        int n = s.length();
        
        // dp[i] means s.substring(0, i) can be segmented
        boolean[] dp = new boolean[n + 1];
        
        // Base case: empty string can be segmented
        dp[0] = true;
        
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                // If prefix s[0...j] is valid AND s[j...i] is in the dictionary
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break; // Move to the next i once we find a valid segmentation
                }
            }
        }
        
        return dp[n];
    }
}
