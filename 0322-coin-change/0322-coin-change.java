class Solution {
    Map<Integer, Integer> memo = new HashMap<>();
    private int dfs(int[] coins, int amount) {
        if(amount==0) return 0;

        if(memo.containsKey(amount)){
            return memo.get(amount);
        }

        int res = (int)1e9;
        for(int coin: coins){
            if(amount-coin>=0){
                res = Math.min(res, 1+dfs(coins, amount-coin));
            }
        }
        memo.put(amount, res);
        return res;
    }

    public int coinChange(int[] coins, int amount) {
        int minCoins = dfs(coins, amount);
        return (minCoins==1e9) ? -1 : minCoins;
    }
}