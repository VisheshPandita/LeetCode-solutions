class Solution {
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        return Math.max(helper(Arrays.copyOfRange(nums, 1, nums.length)), helper(Arrays.copyOfRange(nums, 0, nums.length-1)));
    }

    private int helper(int[] nums){
        int rob1 = 0, rob2 = 0;
        for(int num: nums) {
            int temp = Math.max(num+rob1, rob2);
            rob1 = rob2;
            rob2 = temp;
        }

        return rob2;
    }
}