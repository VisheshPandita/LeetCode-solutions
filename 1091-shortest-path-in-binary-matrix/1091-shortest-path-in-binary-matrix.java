class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(grid[0][0]==1 || grid[n-1][n-1]==1) return -1;

        int[][] dirs = {
            {-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}
        };

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0,1});
        grid[0][0]=1;

        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int row = current[0], col = current[1], distance = current[2];

            if(row == n-1 && col == n-1) return distance;

            for(int[] dir: dirs){
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if(newRow>=0 && newRow<n && newCol>=0 && newCol<n && grid[newRow][newCol]==0){
                    queue.offer(new int[]{newRow, newCol, distance+1});
                    grid[newRow][newCol] = 1;
                }
            }
        }

        return -1;
    }
}