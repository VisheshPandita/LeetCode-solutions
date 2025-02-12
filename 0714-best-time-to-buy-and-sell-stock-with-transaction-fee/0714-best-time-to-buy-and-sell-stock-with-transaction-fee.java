class Solution {
    private Map<String, Integer> memo;
    private int[] prices;
    private int fee;

    public int maxProfit(int[] prices, int fee) {
        this.prices = prices;
        this.fee = fee;
        this.memo = new HashMap<>();
        return dfs(0, 0);
    }

    private int dfs(int index, int holding) {
        if (index == prices.length) return 0;

        String key = index + "_" + holding;
        if (memo.containsKey(key)) return memo.get(key);

        int doNothing = dfs(index + 1, holding);
        int doSomething;

        if (holding == 0) {
            doSomething = dfs(index + 1, 1) - prices[index]; // Buy
        } else {
            doSomething = dfs(index + 1, 0) + prices[index] - fee; // Sell
        }

        int result = Math.max(doNothing, doSomething);
        memo.put(key, result);
        return result;
    }
}