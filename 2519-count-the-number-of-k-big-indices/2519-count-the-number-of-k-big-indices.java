class Solution {
    public int kBigIndices(int[] nums, int k) {
        int n = nums.length;
        boolean[] leftValid = new boolean[n];

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));

        for(int i=0;i<n;i++){
            if(maxHeap.size() == k && maxHeap.peek()<nums[i]) {
                leftValid[i] = true;
            }

            maxHeap.offer(nums[i]);

            if(maxHeap.size()>k) {
                maxHeap.poll();
            }
        }

        maxHeap.clear();
        int count=0;
        for(int i=n-1; i>=0; i--){
            if(maxHeap.size() == k && maxHeap.peek()<nums[i] && leftValid[i]) {
                count++;
            }

            maxHeap.offer(nums[i]);

            if(maxHeap.size()>k){
                maxHeap.poll();
            }
        }

        return count;
    }
}