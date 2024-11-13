class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] result = new int[n];

        result[0] = cost[0];
        result[1] = cost[1];

        for(int i=2;i<n;i++){
            result[i] = cost[i] + Math.min(result[i-1], result[i-2]);
        }

        return Math.min(result[n-1], result[n-2]);
    }
}