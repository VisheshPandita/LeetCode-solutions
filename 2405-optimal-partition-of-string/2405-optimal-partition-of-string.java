class Solution {
    public int partitionString(String s) {
        int ans = 1;
        boolean[] seen = new boolean[26];

        for(char ch: s.toCharArray()) {
            if(seen[ch - 'a']) {
                ans++;
                seen = new boolean[26];
            }

            seen[ch - 'a'] = true;
        }

        return ans;
    }
}