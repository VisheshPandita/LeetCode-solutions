class Solution {
    public int partitionString(String s) {
        int ans = 1;
        int seenMask = 0;

        for(char ch: s.toCharArray()) {
            int bitPosition = ch - 'a';

            if((seenMask & (1 << bitPosition)) != 0) {
                ans++;
                seenMask = 0;
            }

            seenMask |= (1 << bitPosition);
        }

        return ans;
    }
}