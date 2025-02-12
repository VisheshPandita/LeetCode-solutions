class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int MOD = 1_000_000_007;

        int[][] engineers = new int[n][2];
        for(int i=0;i<n;i++){
            engineers[i] = new int[]{efficiency[i], speed[i]};
        }

        Arrays.sort(engineers, (a, b) -> b[0] - a[0]); // Sort by efficiency (descending)
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        long speedSum = 0, maxPerformance = 0;
        
        for (int[] engineer : engineers) {
            int e = engineer[0], s = engineer[1];
            
            if (minHeap.size() == k) {
                speedSum -= minHeap.poll(); // Remove the smallest speed if exceeding k members
            }
            
            minHeap.add(s);
            speedSum += s;
            
            maxPerformance = Math.max(maxPerformance, speedSum * e);
        }
        
        return (int) (maxPerformance % MOD);
    }
}