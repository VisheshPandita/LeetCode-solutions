class Solution {
    public int maxProfit(int[] prices) {
        int hold = -prices[0];
        int notHold = 0;

        for(int i=1; i<prices.length; i++) {
            int prevHold = hold;
            int prevNotHold = notHold;

            hold = Math.max(prevHold, prevNotHold - prices[i]);
            notHold = Math.max(prevNotHold, prevHold + prices[i]);
        }

        return notHold;
    }
}