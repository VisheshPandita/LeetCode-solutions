class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<Integer> leftHeap = new PriorityQueue<>();
        PriorityQueue<Integer> rightHeap = new PriorityQueue<>();

        int n = costs.length;
        int left=0, right=n-1;
        long totalCost = 0;

        while(left<candidates && left<=right) {
            leftHeap.offer(costs[left++]);
        }
        while(right>=n-candidates && right>=left) {
            rightHeap.offer(costs[right--]);
        }

        for (int i = 0; i < k; i++) {
            // Choose the smallest cost from both heaps
            if (!leftHeap.isEmpty() && (rightHeap.isEmpty() || leftHeap.peek() <= rightHeap.peek())) {
                totalCost += leftHeap.poll();
                // Add next eligible worker from the left side
                if (left <= right) {
                    leftHeap.offer(costs[left++]);
                }
            } else {
                totalCost += rightHeap.poll();
                // Add next eligible worker from the right side
                if (left <= right) {
                    rightHeap.offer(costs[right--]);
                }
            }
        }

        return totalCost;
    }
}