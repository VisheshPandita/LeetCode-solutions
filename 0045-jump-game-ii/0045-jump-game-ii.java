class Solution {
    public int jump(int[] nums) {
        int jumps = 0;       // Number of jumps made
        int currentEnd = 0;  // End of the current range
        int farthest = 0;    // Farthest index reachable

        for (int i = 0; i < nums.length - 1; i++) {
            // Update the farthest index reachable
            farthest = Math.max(farthest, i + nums[i]);

            // If we reach the end of the current range
            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;

                // If the currentEnd covers the last index, we can stop
                if (currentEnd >= nums.length - 1) {
                    break;
                }
            }
        }

        return jumps;
    }
}