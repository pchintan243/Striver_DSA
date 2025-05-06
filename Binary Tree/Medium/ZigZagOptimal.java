import java.util.ArrayList;
import java.util.List;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int data;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int val) { data = val; left = null, right = null }
 * }
 **/

class ZigZagOptimal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        //your code goes here
        if(root == null) {
            return List.of();
        }
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean leftToRight = true;

        while(!q.isEmpty()) {
            int n = q.size();
            LinkedList<Integer> level = new LinkedList<>();

            for(int i = 0; i < n; i++) {
                TreeNode curr = q.poll();

                if (leftToRight) {
                    level.addLast(curr.data);
                } else {
                    level.addFirst(curr.data);
                }

                if (curr.left != null) q.offer(curr.left);
                if (curr.right != null) q.offer(curr.right);
            }
            ans.add(level);
            leftToRight = !leftToRight;
        }
        return ans;

    }
}