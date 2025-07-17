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
class PathSum {
    public boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }
    public boolean traverse(TreeNode root, int sum, int targetSum) {
        if(root == null) {
            return false;
        }
        if(isLeaf(root))
            return sum == targetSum;
        boolean left = false;
        if(root.left != null) 
            left = traverse(root.left, sum + root.left.val, targetSum);
        boolean right = false;
        if(root.right != null) 
            right = traverse(root.right, sum + root.right.val, targetSum);

        return left || right;

    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) {
            return false;
        }
        return traverse(root, root.val, targetSum);
    }
}