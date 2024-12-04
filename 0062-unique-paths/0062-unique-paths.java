class Solution {
    int[][] memo;
    public int uniquePaths(int m, int n) {
        memo = new int[m][n];
        for(int[] arr: memo){
            Arrays.fill(arr,-1);
        }
        return dfs(0,0,m,n);
    }

    private int dfs(int i, int j, int m, int n){
        if(i==(m-1) && j==(n-1)) return 1;
        if(i>=m || j>=n) return 0;

        if(memo[i][j]!=-1) return memo[i][j];

        return memo[i][j]=dfs(i,j+1,m,n) + dfs(i+1,j,m,n);
    }
}