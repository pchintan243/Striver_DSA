/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int data;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int val) { data = val; left = null, right = null }
 * }
 **/

class HeightOfTreeRecursive {
    int findDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int left = 1 + findDepth(root.left);
        int right = 1 + findDepth(root.right);

        int ans = Math.max(left, right);
        return ans;
    }
    public int maxDepth(TreeNode root) {
        //your code goes here
        return findDepth(root);
    }
}