class Solution {
    private static final int MOD = 1_000_000_007;
    private int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        Integer[][][] memo = new Integer[m][n][maxMove + 1];
        return dfs(m, n, maxMove, startRow, startColumn, memo);
    }
    
    private int dfs(int m, int n, int movesLeft, int row, int col, Integer[][][] memo) {
        // If out of bounds, it's a valid path.
        if (row < 0 || row >= m || col < 0 || col >= n) {
            return 1;
        }
        // If no moves left, no path possible.
        if (movesLeft == 0) {
            return 0;
        }
        // Check if result is already computed.
        if (memo[row][col][movesLeft] != null) {
            return memo[row][col][movesLeft];
        }
        
        int paths = 0;
        // Explore all 4 directions.
        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            paths = (paths + dfs(m, n, movesLeft - 1, newRow, newCol, memo)) % MOD;
        }
        
        // Store the result in memo table and return.
        memo[row][col][movesLeft] = paths;
        return paths;
    }
}