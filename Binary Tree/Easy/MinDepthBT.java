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
public class MinDepthBT {
    int dfs(TreeNode root, int level) {
        if(root == null) {
            return level;
        }
        if(root.left == null && root.right == null)
            return level;
        int leftLevel = Integer.MAX_VALUE;
        if(root.left != null) {
            leftLevel = dfs(root.left, level + 1);
        }
        int rightLevel = Integer.MAX_VALUE;
        if(root.right != null) {
            rightLevel = dfs(root.right, level + 1);
        }
        return Math.min(leftLevel, rightLevel);
    }
    public int minDepth(TreeNode root) {
        if(root == null)
            return 0;
        return dfs(root, 1);
    }
}
