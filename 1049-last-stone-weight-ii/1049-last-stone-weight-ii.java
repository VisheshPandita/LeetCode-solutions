class Solution {
    public int lastStoneWeightII(int[] stones) {
        int totalSum=0;
        for(int stone: stones) totalSum+=stone;

        int target = totalSum/2;
        boolean[] dp = new boolean[target+1];
        dp[0] = true;

        for(int stone: stones){
            for(int j=target;j>=stone;j--){
                dp[j] = dp[j] || dp[j-stone];
            }
        }

        for(int j=target; j>=0;j--){
            if(dp[j]) return totalSum - 2*j;
        }

        return 0;
    }
}