class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        List<List<String>> result = new ArrayList<>();

        if(!dict.contains(endWord)) return result;
        dict.remove(beginWord);

        Map<String, List<String>> parents = new HashMap<>();

        Set<String> currLevel = new HashSet<>();
        currLevel.add(beginWord);
        boolean found = false;

        while(!currLevel.isEmpty() && !found) {
            Set<String> nextLevel = new HashSet<>();

            for(String word: currLevel) {
                char[] chars = word.toCharArray();

                for(int i=0; i<chars.length; i++) {
                    char original = chars[i];

                    for(char c='a'; c<='z'; c++) {
                        if(c == original) continue;

                        chars[i] = c;
                        String next = new String(chars);

                        if(!dict.contains(next)) continue;

                        nextLevel.add(next);
                        parents.computeIfAbsent(next, k -> new ArrayList<>()).add(word);

                        if(next.equals(endWord)) found = true;
                    }

                    chars[i] = original;
                }
            }

            dict.removeAll(nextLevel);
            currLevel = nextLevel;
        }

        if (!found) return result;

        LinkedList<String> path = new LinkedList<>();
        path.add(endWord);
        backtrack(endWord, beginWord, parents, path, result);

        return result;
    }

    private void backtrack(String word, String beginWord,
                           Map<String, List<String>> parents,
                           LinkedList<String> path,
                           List<List<String>> result) {
        if (word.equals(beginWord)) {
            result.add(new ArrayList<>(path));   // copy — path is mutated afterwards
            return;
        }

        for (String parent : parents.getOrDefault(word, Collections.emptyList())) {
            path.addFirst(parent);                          // build path in correct order
            backtrack(parent, beginWord, parents, path, result);
            path.removeFirst();                             // undo — classic backtracking
        }
    }
}