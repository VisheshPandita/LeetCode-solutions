class Solution {
    public int removeDuplicates(int[] nums) {
        int slow=0;

        for (int num : nums) {
            if (slow < 2 || num != nums[slow - 2]) {
                nums[slow] = num;
                slow++;
            }
        }
        return slow;
    }
}