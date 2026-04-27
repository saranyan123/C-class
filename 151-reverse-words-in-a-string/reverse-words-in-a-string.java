import java.util.*;

class Solution {
    public String reverseWords(String s) {
        // 1. Trim leading/trailing spaces and split by one or more spaces
        // "\\s+" is a regex that matches any sequence of whitespace
        String[] words = s.trim().split("\\s+");

        // 2. Convert to a list so we can use Collections.reverse()
        List<String> wordList = Arrays.asList(words);
        Collections.reverse(wordList);

        // 3. Join the words back together with a single space
        return String.join(" ", wordList);
    }
}
