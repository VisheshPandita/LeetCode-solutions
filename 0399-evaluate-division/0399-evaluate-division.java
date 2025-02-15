class Solution {
    static class Pair {
        String node;
        double value;

        Pair(String node, double value){
            this.node = node;
            this.value = value;
        }
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<Pair>> graph = new HashMap<>();

        // Build Graph
        for(int i=0;i<equations.size();i++){
            String A = equations.get(i).get(0);
            String B = equations.get(i).get(1);
            double value = values[i];

            graph.putIfAbsent(A, new ArrayList<>());
            graph.putIfAbsent(B, new ArrayList<>());
            graph.get(A).add(new Pair(B, value));
            graph.get(B).add(new Pair(A, 1.0 / value));
        }

        // Process Queries
        double[] results = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String start = queries.get(i).get(0);
            String end = queries.get(i).get(1);
            if (!graph.containsKey(start) || !graph.containsKey(end)) {
                results[i] = -1.0;
            } else {
                results[i] = dfs(graph, start, end, new HashSet<>(), 1.0);
            }
        }
        return results;
    }

    private double dfs(Map<String, List<Pair>> graph, String start, String end, Set<String> visited, double value) {
        if (start.equals(end)) return value;
        visited.add(start);
        for (Pair neighbor : graph.get(start)) {
            if (!visited.contains(neighbor.node)) {
                double result = dfs(graph, neighbor.node, end, visited, value * neighbor.value);
                if (result != -1.0) return result;
            }
        }
        return -1.0;
    }
}