import java.util.*;

public class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> results = new ArrayList<>();
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) return results;

        // BFS to build a graph of shortest paths
        Map<String, List<String>> predecessors = new HashMap<>();
        Map<String, Integer> distance = new HashMap<>();
        Queue<String> queue = new LinkedList<>();

        queue.offer(beginWord);
        distance.put(beginWord, 0);

        boolean found = false;
        int minDistance = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            String word = queue.poll();
            int curDistance = distance.get(word);

            if (curDistance >= minDistance) break;

            char[] chars = word.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char old = chars[i];
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    chars[i] = ch;
                    String nextWord = new String(chars);

                    if (dict.contains(nextWord)) {
                        // If first time visiting or found another shortest path
                        if (!distance.containsKey(nextWord) || distance.get(nextWord) == curDistance + 1) {
                            if (!distance.containsKey(nextWord)) {
                                distance.put(nextWord, curDistance + 1);
                                queue.offer(nextWord);
                            }
                            
                            predecessors.computeIfAbsent(nextWord, k -> new ArrayList<>()).add(word);

                            if (nextWord.equals(endWord)) {
                                found = true;
                                minDistance = curDistance + 1;
                            }
                        }
                    }
                }
                chars[i] = old;
            }
        }

        if (found) {
            Deque<String> path = new ArrayDeque<>();
            path.addFirst(endWord);
            backtrack(endWord, beginWord, predecessors, path, results);
        }

        return results;
    }

    private void backtrack(String current, String beginWord, Map<String, List<String>> predecessors, 
                           Deque<String> path, List<List<String>> results) {
        if (current.equals(beginWord)) {
            results.add(new ArrayList<>(path));
            return;
        }

        if (predecessors.containsKey(current)) {
            for (String pred : predecessors.get(current)) {
                path.addFirst(pred);
                backtrack(pred, beginWord, predecessors, path, results);
                path.removeFirst();
            }
        }
    }
}
