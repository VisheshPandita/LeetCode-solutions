class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        
        List<List<Integer>> reverseGraph = new ArrayList<>();
        for(int i=0;i<n;i++) reverseGraph.add(new ArrayList<>());

        int[] indegree = new int[n];
        for(int u=0;u<n;u++){
            for(int v: graph[u]){
                reverseGraph.get(v).add(u);
                indegree[u]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indegree[i] == 0) queue.add(i);
        }

        List<Integer> result = new ArrayList<>();
        while(!queue.isEmpty()){
            int node = queue.poll();
            result.add(node);

            for(int neighbour: reverseGraph.get(node)){
                indegree[neighbour]--;
                if(indegree[neighbour]==0) queue.add(neighbour);
            }
        }

        Collections.sort(result);
        return result;
    }
}