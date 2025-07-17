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
class BinaryTreePaths {
    public boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }
    void dfs(TreeNode root, String sb, List<String> ans) {
        if(isLeaf(root)) {
            ans.add(sb.toString());
            return;
        }
        String prefix = sb + "->";
        if(root.left != null) {
            dfs(root.left, prefix + root.left.val, ans);
        }

        if(root.right != null) {
            dfs(root.right, prefix + root.right.val, ans);
        }
    }
    public List<String> binaryTreePaths(TreeNode root) {
        if(root == null)
            return List.of();
        List<String> ans = new ArrayList<>();
        dfs(root, root.val + "", ans);
        if(isLeaf(root)) {
            return ans;
        }
        return ans;
    }
}