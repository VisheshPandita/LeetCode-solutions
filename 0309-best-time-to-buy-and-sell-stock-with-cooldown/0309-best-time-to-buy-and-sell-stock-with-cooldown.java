class Solution {
    Map<String, Integer> cache = new HashMap<>();
    public int maxProfit(int[] prices) {
        return dfs(0, true, prices);
    }

    public int dfs(int i, boolean buying, int[] prices) {
        if(i>=prices.length) return 0;

        String key = i + "-" + buying;
        if(cache.containsKey(key)){
            return cache.get(key);
        }

        int cooldown = dfs(i+1, buying, prices);
        if(buying) {
            int buy = dfs(i+1, false, prices) - prices[i];
            cache.put(key, Math.max(buy, cooldown));
        }else{
            int sell = dfs(i+2, true, prices) + prices[i];
            cache.put(key, Math.max(sell, cooldown));
        }

        return cache.get(key);
    }
}