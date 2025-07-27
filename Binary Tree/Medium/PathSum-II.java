package Binary Tree.Medium;
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
class PathSum-II {
    private boolean isLeafNode(TreeNode curr) {
        return curr.left == null && curr.right == null;
    }

    private void dfs(TreeNode curr, List<Integer> temp, int sum, int target, List<List<Integer>> ans) {
        if(curr == null) {
            return;
        }
        if(isLeafNode(curr)) {
            if(sum + curr.val == target) {
                temp.add(curr.val);
                ans.add(new ArrayList<>(temp));
                temp.remove(temp.size() - 1);
            }
            return;
        }
        temp.add(curr.val);
        dfs(curr.left, temp, sum + curr.val, target, ans);
        dfs(curr.right, temp, sum + curr.val, target, ans);
        temp.remove(temp.size() - 1);
        
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();

        dfs(root, new ArrayList<>(), 0, targetSum, ans);

        return ans;
    }
}