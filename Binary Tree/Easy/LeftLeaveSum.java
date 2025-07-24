package Binary Tree.Easy;

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
class LeftLeaveSum {
    private boolean isLeaf(TreeNode curr) {
        return curr.left == null && curr.right == null;
    }
    void dfs(TreeNode curr, int[] ans) {
        if(curr == null) {
            return;
        }
        if(curr.left != null) {
            if(isLeaf(curr.left))
                ans[0] += curr.left.val;
            dfs(curr.left, ans);
        }
        dfs(curr.right, ans);
    }
    public int sumOfLeftLeaves(TreeNode root) {
        int[] ans = new int[1];
        dfs(root, ans);

        return ans[0];
    }
}