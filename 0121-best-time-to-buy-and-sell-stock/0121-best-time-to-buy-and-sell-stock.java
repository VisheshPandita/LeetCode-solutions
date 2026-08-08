class Solution {
    public int maxProfit(int[] prices) {
        int profit=0;
        int min=Integer.MAX_VALUE;
        int max=0;

        for(int price: prices) {
            min = Math.min(price, min);
            if(min == price) {
                max = min;
            }else{
                max = Math.max(max, price);
            }

            profit = Math.max(profit, max-min);
        }

        return profit;
    }
}