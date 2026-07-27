class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if(n<2) return s.length();

        Map<Character, Boolean> data = new HashMap<>();

        int left = 0;
        int right = 1;
        data.put(s.charAt(0), true);

        int length=1;

        while(right < n && left < right) {
            while(left < right && data.getOrDefault(s.charAt(right), false)) {
                data.put(s.charAt(left), false);
                left++;
            }
            data.put(s.charAt(right), true);
            length = Math.max(length, right - left + 1);
            right++;
        }

        return length;
    }
}