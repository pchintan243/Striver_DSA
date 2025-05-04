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
class ZigZagTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null)
            return List.of();
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        boolean flag = true;
        while(!q.isEmpty()) {
            int n = q.size();
            List<Integer> temp = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                TreeNode curr = q.poll();
                if(curr.right != null) {
                    q.offer(curr.right);
                }

                if(curr.left != null) {
                    q.offer(curr.left);
                }
                temp.add(curr.val);
            }
            flag = !flag;
            if(!flag) {
                Collections.reverse(temp);
            }
            ans.add(temp);
        }
        return ans;
    }
}