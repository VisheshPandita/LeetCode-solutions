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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        Set<TreeNode> cache = new HashSet<>();
        for(TreeNode node: nodes) {
            cache.add(node);
        }

        return dfs(root, cache);
    }

    private TreeNode dfs(TreeNode curr, Set<TreeNode> cache) {
        if(curr == null) return null;

        if(cache.contains(curr)) {
            return curr;
        }

        TreeNode left = dfs(curr.left, cache);
        TreeNode right = dfs(curr.right, cache);

        if(left!=null && right!=null) return curr;

        return left!=null ? left : right;
    }
}