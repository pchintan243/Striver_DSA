package Binary Search Tree.Medium;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int data;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int val) { data = val; left = null, right = null }
 * }
 **/

class CheckValidBST {
    boolean checkBST(TreeNode root, int min, int max) {
        if(root == null)
            return true;
        if(root.data >= max || root.data <= min) {
            return false;
        }
        boolean left = checkBST(root.left, min, root.data);
        boolean right = checkBST(root.right, root.data, max);
        return left && right;
    }
    public boolean isBST(TreeNode root) {
        //your code goes here
        return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}