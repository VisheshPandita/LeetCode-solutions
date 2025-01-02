class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[numCourses];

        for(int i=0;i<numCourses;i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] prereq: prerequisites) {
            int course = prereq[0];
            int prerequisite = prereq[1];
            graph.get(prerequisite).add(course);
            indegree[course]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0) queue.offer(i);
        }

        int[] result = new int[numCourses];
        int ptr = 0;
        while(!queue.isEmpty()){
            int course = queue.poll();
            result[ptr] = course;
            ptr++;

            for(int neighbour: graph.get(course)){
                indegree[neighbour]--;
                if(indegree[neighbour]==0){
                    queue.offer(neighbour);
                }
            }
        }

        return (ptr == numCourses) ? result : new int[]{};
    }
}