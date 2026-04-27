import java.util.Arrays;

public class Solution {
    public int minCut(String s) {
        int n = s.length();
        if (n <= 1) return 0;

        // cuts[i] is the min cuts needed for substring s[0...i]
        int[] cuts = new int[n];
        // isPal[j][i] is true if s[j...i] is a palindrome
        boolean[][] isPal = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            // Maximum possible cuts for s[0...i] is i (cutting every character)
            int minCuts = i; 
            
            for (int j = 0; j <= i; j++) {
                // If s[j...i] is a palindrome
                // 1. characters at j and i must match
                // 2. the inner substring s[j+1...i-1] must be a palindrome (or length < 2)
                if (s.charAt(j) == s.charAt(i) && (i - j < 2 || isPal[j + 1][i - 1])) {
                    isPal[j][i] = true;
                    
                    // If the whole prefix s[0...i] is a palindrome, 0 cuts needed
                    if (j == 0) {
                        minCuts = 0;
                    } else {
                        // Otherwise, take cuts for s[0...j-1] and add 1 cut for s[j...i]
                        minCuts = Math.min(minCuts, cuts[j - 1] + 1);
                    }
                }
            }
            cuts[i] = minCuts;
        }

        return cuts[n - 1];
    }
}
