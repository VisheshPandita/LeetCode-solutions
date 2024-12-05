/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private void buildGraph(TreeNode node, Map<TreeNode, List<TreeNode>> graph, TreeNode parent){
        if(node==null) return;

        graph.putIfAbsent(node, new ArrayList<TreeNode>());
        if(parent!=null){
            graph.get(node).add(parent);
            graph.get(parent).add(node);
        }
        buildGraph(node.left, graph, node);
        buildGraph(node.right, graph, node);
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        // build graph from tree
        Map<TreeNode, List<TreeNode>> graph = new HashMap<>();
        buildGraph(root, graph, null);

        // bfs on graph
        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();

        queue.add(target);
        visited.add(target);

        int currentDistance = 0;

        while(!queue.isEmpty()){
            if(currentDistance == k) break;

            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode currentNode = queue.poll();
                for(TreeNode neighbour: graph.get(currentNode)){
                    if(!visited.contains(neighbour)){
                        visited.add(neighbour);
                        queue.add(neighbour);
                    }
                }
            }

            currentDistance++;
        }

        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            result.add(queue.poll().val);
        }

        return result;
    }
}