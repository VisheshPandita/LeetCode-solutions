class Solution {
    public boolean canJump(int[] nums) {
        int ptr=0;

        for(int i=0;i<nums.length;i++){
            if(ptr<i) return false;

            ptr = Math.max(ptr, nums[i]+i);

            if(ptr>=nums.length-1) return true;
        }

        return false;
    }
}