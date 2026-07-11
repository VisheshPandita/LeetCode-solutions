class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
        }

        for(int i=0;i<n;i++){
            if(manager[i]!=-1) {
                adjList.get(manager[i]).add(i);
            }
        }

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{headID, 0});

        int maxMin=0;

        while(!queue.isEmpty()) {
            int[] currNode = queue.poll();
            int node = currNode[0];
            int time = currNode[1];
            maxMin = Math.max(maxMin, time);

            for(int neighbour: adjList.get(node)) {
                queue.offer(new int[]{neighbour, time+informTime[node]});
            }
        }

        return maxMin;
    }
}