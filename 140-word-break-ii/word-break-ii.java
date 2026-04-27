import java.util.*;

class Solution {
    // Memoization map to store results for substrings
    private Map<String, List<String>> memo = new HashMap<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        return dfs(s, wordSet);
    }

    private List<String> dfs(String s, Set<String> wordSet) {
        // If we've already solved this substring, return the stored result
        if (memo.containsKey(s)) {
            return memo.get(s);
        }

        List<String> results = new ArrayList<>();
        
        // Base case: if the string is empty, return a list containing an empty string
        if (s.isEmpty()) {
            results.add("");
            return results;
        }

        // Try every possible prefix
        for (int i = 1; i <= s.length(); i++) {
            String prefix = s.substring(0, i);
            
            if (wordSet.contains(prefix)) {
                // Recursively solve for the remaining suffix
                List<String> suffixWays = dfs(s.substring(i), wordSet);
                
                for (String way : suffixWays) {
                    // If suffix was the end of the string, don't add a space
                    String space = way.isEmpty() ? "" : " ";
                    results.add(prefix + space + way);
                }
            }
        }

        memo.put(s, results);
        return results;
    }
}
