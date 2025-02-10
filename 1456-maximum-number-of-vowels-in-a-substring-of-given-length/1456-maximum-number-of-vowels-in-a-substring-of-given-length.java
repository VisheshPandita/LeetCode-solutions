class Solution {
    public int maxVowels(String s, int k) {
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        int maxVowels = 0, currentCount = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (vowels.contains(s.charAt(i))) {
                currentCount++;
            }
            
            if (i >= k && vowels.contains(s.charAt(i - k))) {
                currentCount--;
            }
            
            if (i >= k - 1) {
                maxVowels = Math.max(maxVowels, currentCount);
            }
        }
        
        return maxVowels;
    }
}