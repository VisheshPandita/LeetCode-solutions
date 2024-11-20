class Solution {
    private int dfs(int i, String s, Map<Integer, Integer> dp) {
        if(dp.containsKey(i)) {
            return dp.get(i);
        }
        if(i==s.length()) return 1;
        if(s.charAt(i)=='0') return 0;

        int res = dfs(i+1, s, dp);
        if(i<s.length()-1){
            if (s.charAt(i) == '1' || 
               (s.charAt(i) == '2' && s.charAt(i + 1) < '7')) {
                res += dfs(i + 2, s, dp);
            }
        }
        dp.put(i, res);
        return res;
    }

    public int numDecodings(String s) {
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(s.length(), 1);
        return dfs(0, s, dp);
    }
}