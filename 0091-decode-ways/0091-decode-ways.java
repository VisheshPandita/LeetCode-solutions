class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        if (n == 0 || s.charAt(0) == '0') return 0;  // Invalid start

        int[] dp = new int[n + 1];
        dp[0] = 1;  // Empty string has one way
        dp[1] = s.charAt(0) != '0' ? 1 : 0;  

        for (int i = 2; i <= n; i++) {
            int oneDigit = Integer.parseInt(s.substring(i - 1, i)); // Single digit
            int twoDigits = Integer.parseInt(s.substring(i - 2, i)); // Two-digit number

            if (oneDigit >= 1) dp[i] += dp[i - 1];  // Single digit decoding
            if (twoDigits >= 10 && twoDigits <= 26) dp[i] += dp[i - 2];  // Two-digit decoding
        }
        return dp[n];
    }
}