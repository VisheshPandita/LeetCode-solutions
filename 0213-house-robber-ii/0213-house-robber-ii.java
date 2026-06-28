class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];

        int maxA = robRange(nums, 0, nums.length-2);
        int maxB = robRange(nums, 1, nums.length-1);

        return Math.max(maxA, maxB);
    }

    private int robRange(int[] nums, int start, int end) {
        int prev1=0;
        int prev2=0;

        for(int i=start;i<=end;i++){
            int currentMax = Math.max(prev1, prev2+nums[i]);

            prev2 = prev1;
            prev1 = currentMax;
        }

        return prev1;
    }
}