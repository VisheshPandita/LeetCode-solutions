class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        for(int i=0; i<=k; i++) {
            int[] tempDist = Arrays.copyOf(dist, n);
            for(int[] flight: flights){
                int u = flight[0], v = flight[1], price = flight[2];

                if(dist[u] != Integer.MAX_VALUE && dist[u]+price < tempDist[v]) {
                    tempDist[v] = dist[u] + price;
                }
            }

            dist = tempDist;
        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}