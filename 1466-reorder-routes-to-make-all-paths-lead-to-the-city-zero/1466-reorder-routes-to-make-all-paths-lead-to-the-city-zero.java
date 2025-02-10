class Solution {
    public int minReorder(int n, int[][] connections) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        for (int[] conn : connections) {
            graph.get(conn[0]).add(new int[]{conn[1], 1});
            graph.get(conn[1]).add(new int[]{conn[0], 0});
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        queue.add(0);
        visited[0] = true;
        int count = 0;

        while (!queue.isEmpty()) {
            int city = queue.poll();
            for (int[] neighbor : graph.get(city)) {
                if (!visited[neighbor[0]]) {
                    visited[neighbor[0]] = true;
                    queue.add(neighbor[0]);
                    count += neighbor[1];
                }
            }
        }
        return count;
    }
}