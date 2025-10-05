package Binary Search Tree.Easy;

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
public class MinDistanceBSTNodes {
    int min;
    TreeNode prev;
    void inorder(TreeNode root) {
        if(root == null) {
            return;
        }
        inorder(root.left);
        if(prev != null) {
            min = Math.min(min, root.val - prev.val);
        }
        prev = root;
        inorder(root.right);
    }
    public int minDiffInBST(TreeNode root) {
        min = Integer.MAX_VALUE;
        prev = null;
        inorder(root);
        return min;
    }
}