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
    int maxLength=0;

    public int longestZigZag(TreeNode root) {
        dfs(root, -1, 0);
        return maxLength;
    }

    private void dfs(TreeNode node, int direction, int length) {
        if(node==null) return;
        maxLength = Math.max(maxLength, length);
        dfs(node.left, 0, direction==1?length+1:1);
        dfs(node.right,1, direction==0?length+1:1);
    }
}