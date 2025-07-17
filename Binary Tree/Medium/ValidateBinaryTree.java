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
class ValidateBinaryTree {
    public boolean checkIsValid(TreeNode root, long minVal, long maxVal) {
        if(root == null)
            return true;
        if(minVal >= root.val || root.val >= maxVal) {
            return false;
        }
        boolean left = checkIsValid(root.left, minVal, root.val);
        boolean right = checkIsValid(root.right, root.val, maxVal);

        return left && right;
    }
    public boolean isValidBST(TreeNode root) {
        return checkIsValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
}
