class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        List<List<Integer>> redAdj = new ArrayList<>();
        List<List<Integer>> blueAdj = new ArrayList<>();
        for(int i=0;i<n;i++) {
            redAdj.add(new ArrayList<>());
            blueAdj.add(new ArrayList<>());
        }

        for(int[] edge: redEdges) {
            redAdj.get(edge[0]).add(edge[1]);
        }
        for(int[] edge: blueEdges) {
            blueAdj.get(edge[0]).add(edge[1]);
        }

        int[][] dist = new int[n][2];
        for(int[] node: dist) {
            Arrays.fill(node, Integer.MAX_VALUE);
        }

        Queue<int[]> queue = new ArrayDeque<>();

        dist[0][0] = 0;
        dist[0][1] = 0;
        queue.add(new int[]{0,0});
        queue.add(new int[]{0,1});

        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            int node = curr[0];
            int colorUsed = curr[1];
            int currDist = dist[node][colorUsed];

            List<Integer> neighbours = (colorUsed == 0) ? blueAdj.get(node) : redAdj.get(node);
            int nextColor = colorUsed ^ 1;

            for(int neighbour: neighbours) {
                if(dist[neighbour][nextColor] == Integer.MAX_VALUE) {
                    dist[neighbour][nextColor] = currDist + 1;
                    queue.offer(new int[]{neighbour, nextColor});
                }
            }
        }

        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            int best = Math.min(dist[i][0], dist[i][1]);
            answer[i] = (best == Integer.MAX_VALUE) ? -1 : best;
        }
        return answer;
    }
}