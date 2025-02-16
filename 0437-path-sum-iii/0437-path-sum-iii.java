/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        HashMap<Long, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0L, 1); // Base case: one way to get sum 0
        return dfs(root, 0, targetSum, prefixSumCount);
    }

    private int dfs(TreeNode node, long currSum, int targetSum, HashMap<Long, Integer> prefixSumCount) {
        if (node == null) return 0;

        currSum += node.val;
        int count = prefixSumCount.getOrDefault(currSum - targetSum, 0);

        // Add current prefix sum to hashmap
        prefixSumCount.put(currSum, prefixSumCount.getOrDefault(currSum, 0) + 1);

        // Recur for left and right children
        count += dfs(node.left, currSum, targetSum, prefixSumCount);
        count += dfs(node.right, currSum, targetSum, prefixSumCount);

        // Backtrack: remove the current sum after returning from recursion
        prefixSumCount.put(currSum, prefixSumCount.get(currSum) - 1);
        
        return count;
    }
}