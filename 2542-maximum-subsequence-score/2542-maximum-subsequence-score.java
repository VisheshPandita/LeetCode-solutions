class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int[][] pairs = new int[n][2];

        for(int i=0;i<n;i++) pairs[i] = new int[]{nums2[i], nums1[i]};

        Arrays.sort(pairs, (a, b) -> Integer.compare(b[0], a[0]));

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        long sum = 0, maxScore = 0;

        for (int i = 0; i < n; i++) {
            int weight = pairs[i][0], value = pairs[i][1];
            minHeap.add(value);
            sum += value;

            if (minHeap.size() > k) {
                sum -= minHeap.poll();
            }

            if (minHeap.size() == k) {
                maxScore = Math.max(maxScore, sum * weight);
            }
        }

        return maxScore; 
    }
}