/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int data;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int val) { data = val; left = null, right = null }
 * }
 **/

class FindDiameter {
    int findDiameter(TreeNode root, int[] height) {
        if(root == null) {
            return 0;
        }
        int left = findDiameter(root.left, height);
        int right = findDiameter(root.right, height);
        height[0] = Math.max(height[0], left + right);
        return 1 + Math.max(left, right);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        //your code goes here
        if(root == null)
            return 0;
        int[] diameter = new int[1];
        findDiameter(root, diameter);
        return diameter[0];
    }
}