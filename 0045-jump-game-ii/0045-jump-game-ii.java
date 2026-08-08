class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for(int i=0; i<n; i++) {
            int start = i+1;
            int end = i+nums[i];
            while(start<=end && start<n) {
                dp[start] = Math.min(dp[start], dp[i]+1);
                start++;
            }
        }

        return dp[n-1] == Integer.MAX_VALUE ? -1 : dp[n-1];
    }
}