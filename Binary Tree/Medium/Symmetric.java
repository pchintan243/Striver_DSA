/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int data;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int val) { data = val; left = null, right = null }
 * }
 **/

class Symmetric {
    boolean checkSymmetric(TreeNode left, TreeNode right) {
        if(left == null || right == null)
            return left == right;
        if(left.data != right.data) {
            return false;
        }

        return checkSymmetric(left.left, right.right) && checkSymmetric(left.right, right.left);
    }
    public boolean isSymmetric(TreeNode root) {
        //your code goes here
        return root == null || checkSymmetric(root.left, root.right);
    }
}