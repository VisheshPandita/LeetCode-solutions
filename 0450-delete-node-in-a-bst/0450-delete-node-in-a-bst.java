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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        if (key < root.val) {
            root.left = deleteNode(root.left, key);  // Search in left subtree
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key); // Search in right subtree
        } else {
            // Node found
            if (root.left == null) return root.right;  // Case 1 & 2: No child or one child (right)
            if (root.right == null) return root.left;  // Case 2: One child (left)

            // Case 3: Two children
            TreeNode successor = findMin(root.right); // Find inorder successor
            root.val = successor.val; // Replace value
            root.right = deleteNode(root.right, successor.val); // Delete successor
        }
        return root;
    }

    private TreeNode findMin(TreeNode node) {
        while (node.left != null) node = node.left;
        return node;
    }
}