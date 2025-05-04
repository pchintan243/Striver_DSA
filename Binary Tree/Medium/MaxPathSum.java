/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int data;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int val) { data = val; left = null, right = null }
 * }
 **/

class MaxPathSum {
    int findSum(TreeNode root, int[] sum) {
        if(root == null) {
            return 0;
        }
        int left = findSum(root.left, sum);
        if(left < 0)
            left = 0;
        int right = findSum(root.right, sum);
        if(right < 0)
            right = 0;
        sum[0] = Math.max(sum[0], left + right + root.data);
        return root.data + Math.max(left, right);
    }

    public int maxPathSum(TreeNode root) {
        //your code goes here 
        if(root == null)
            return 0;
        int[] sum = new int[1];
        findSum(root, sum);
        return sum[0];
    }
}