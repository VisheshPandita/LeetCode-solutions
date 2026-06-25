class Solution {
    public int minimumOperations(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        
        // Use long to prevent integer overflow during massive continuous merges
        long leftSum = nums[left];
        long rightSum = nums[right];
        
        int mergeOperations = 0;

        while (left < right) {
            if (leftSum == rightSum) {
                left++;
                right--;
                
                if (left <= right) {
                    leftSum = nums[left];
                    rightSum = nums[right];
                }
            } 
            else if (leftSum < rightSum) {
                left++;
                leftSum += nums[left];
                mergeOperations++;
            } 
            else {
                right--;
                rightSum += nums[right];
                mergeOperations++;
            }
        }

        return mergeOperations;
    }
}