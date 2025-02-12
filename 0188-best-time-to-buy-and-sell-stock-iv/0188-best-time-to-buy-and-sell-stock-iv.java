class Solution {
    private Map<String, Integer> memo;
    private int[] prices;

    public int maxProfit(int k, int[] prices) {
        this.prices = prices;
        this.memo = new HashMap<>();
        return dfs(0, k, 0);
    }

    private int dfs(int index, int transactionsRemaining, int holding) {
        if (index == prices.length || transactionsRemaining == 0) return 0;

        String key = index + "_" + transactionsRemaining + "_" + holding;
        if (memo.containsKey(key)) return memo.get(key);

        int doNothing = dfs(index + 1, transactionsRemaining, holding);
        int doSomething;

        if (holding == 0) {
            doSomething = dfs(index + 1, transactionsRemaining, 1) - prices[index]; // Buy
        } else {
            doSomething = dfs(index + 1, transactionsRemaining - 1, 0) + prices[index]; // Sell
        }

        int result = Math.max(doNothing, doSomething);
        memo.put(key, result);
        return result;
    }
}