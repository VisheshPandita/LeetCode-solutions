class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    private int atMost(int[] nums, int k) {
        int count = 0, start = 0, oddCount = 0;

        for (int end = 0; end < nums.length; end++) {
            // Count odd numbers in the current window
            if (nums[end] % 2 != 0) {
                oddCount++;
            }

            // Shrink the window if the number of odd numbers exceeds k
            while (oddCount > k) {
                if (nums[start] % 2 != 0) {
                    oddCount--;
                }
                start++;
            }

            // Add the number of subarrays ending at `end`
            count += end - start + 1;
        }

        return count;
    }
}
