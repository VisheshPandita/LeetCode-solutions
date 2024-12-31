class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for(int[] time: times){
            graph.computeIfAbsent(time[0], x -> new ArrayList<>()).add(new int[]{time[1], time[2]});
        }

        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k]=0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.offer(new int[]{k,0});

        while(!pq.isEmpty()){
            int[] current = pq.poll();
            int node = current[0], time = current[1];

            if(time>dist[node]) continue;

            if(graph.containsKey(node)){
                for(int[] neighbour: graph.get(node)){
                    int nextNode = neighbour[0], weight = neighbour[1];
                    if(dist[node] + weight < dist[nextNode]){
                        dist[nextNode] = dist[node] + weight;
                        pq.offer(new int[]{nextNode, dist[nextNode]});
                    }
                }
            }
        }

        int maxTime=0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                return -1;
            }
            maxTime = Math.max(maxTime, dist[i]);
        }

        return maxTime;
    }
}