class Solution {
    public int longestPalindromeSubseq(String s) {
        int result=0;
        int n = s.length();
        char[] string1 = new char[n];
        char[] string2 = new char[n];

        for(int i=0;i<n;i++){
            string1[i]=s.charAt(i);
            string2[i]=s.charAt(n-(i+1));
        }

        int[][] dp = new int[n+1][n+1];
        for(int i=0;i<=n;i++){
            dp[i][n]=0;
            dp[n][i]=0;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(string1[i-1]==string2[j-1]){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }

        return dp[n][n];
    }
}