class Solution {
    public int maxProfit(int[] prices) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.offer(prices[0]);
        int profit = 0;

        for(int i=1; i<prices.length; i++) {
            if(prices[i]>queue.peekLast()){
                queue.offer(prices[i]);
            }else if(prices[i]<queue.peekFirst()) {
                queue.clear();
                queue.offer(prices[i]);
            }
            profit = Math.max(profit, queue.peekLast() - queue.peekFirst());
        }

        return profit;
    }
}