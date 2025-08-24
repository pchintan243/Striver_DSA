package Binary Search Tree.Medium;
import java.util.ArrayList;
import java.util.List;

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
public class KthSamllestElement {
    List<Integer> ans;
    void dfs(TreeNode curr) {
        if(curr == null) {
            return;
        }

        dfs(curr.left);
        ans.add(curr.val);
        dfs(curr.right);
    }
    public int kthSmallest(TreeNode root, int k) {
        ans = new ArrayList<>();
        dfs(root);
        return ans.get(k - 1);
    }
}