class Solution {
    static class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if(!wordSet.contains(endWord)) return 0;

        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(beginWord, 1));

        while(!queue.isEmpty()){
            Pair<String, Integer> node = queue.poll();
            String currentWord = node.getKey();
            int currentLevel = node.getValue();

            for(int i=0;i<currentWord.length();i++){
                char[] wordChars = currentWord.toCharArray();
                for(char c='a';c<='z';c++) {
                    wordChars[i] = c;
                    String nextWord = new String(wordChars);

                    if (nextWord.equals(endWord)) {
                        return currentLevel + 1; 
                    }

                    if (wordSet.contains(nextWord)) {
                        wordSet.remove(nextWord);
                        queue.offer(new Pair<>(nextWord, currentLevel + 1));
                    }
                }
            }
        }

        return 0;
    }
}