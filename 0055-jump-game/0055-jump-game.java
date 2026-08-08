class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n];
        dp[0] = true;

        for(int i=0; i<n; i++) {
            if(dp[i]) {
                int start = i+1;
                int end = i + nums[i];

                while(start<=end && start<n) {
                    dp[start] = true;
                    start++;
                }
            }
        }

        return dp[n-1];
    }
}