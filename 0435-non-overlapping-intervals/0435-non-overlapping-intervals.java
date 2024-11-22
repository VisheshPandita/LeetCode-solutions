class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        // Sort intervals by their end time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int count = 0; // Number of intervals to remove
        int prevEnd = Integer.MIN_VALUE; // End time of the last non-overlapping interval

        for (int[] interval : intervals) {
            // If there is an overlap
            if (interval[0] < prevEnd) {
                count++;
            } else {
                // Update the end time of the last non-overlapping interval
                prevEnd = interval[1];
            }
        }

        return count;
    }
}