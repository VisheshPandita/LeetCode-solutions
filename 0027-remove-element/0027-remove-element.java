class Solution {
    public int removeElement(int[] nums, int val) {
        int left=0;
        int right=nums.length;

        while(left<right) {
            if(nums[left] == val) {
                right--;
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }else {
                left++;
            }
        }
        
        return left;
    }
}