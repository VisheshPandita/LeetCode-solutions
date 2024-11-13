class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        if(n==1) return nums[0];

        res[0] = nums[0];
        int max = res[0];
        res[1] = nums[1];

        for(int i=2;i<n;i++){
            res[i] = nums[i] + Math.max(max, res[i-2]);
            if(res[i-1]>max) max = res[i-1];
        }

        return Math.max(max, res[n-1]);
    }
}