class Solution {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) return false;

        // Frequency arrays
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        // Character presence arrays
        boolean[] present1 = new boolean[26];
        boolean[] present2 = new boolean[26];

        // Count character frequencies and presence
        for (char c : word1.toCharArray()) {
            freq1[c - 'a']++;
            present1[c - 'a'] = true;
        }
        for (char c : word2.toCharArray()) {
            freq2[c - 'a']++;
            present2[c - 'a'] = true;
        }

        // 1st condition: Must have the same unique characters
        if (!Arrays.equals(present1, present2)) return false;

        // 2nd condition: The sorted frequency counts must match
        Arrays.sort(freq1);
        Arrays.sort(freq2);
        return Arrays.equals(freq1, freq2);
    }
}