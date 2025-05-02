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

class LevelTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        //your code goes here
        if(root == null)
            return List.of();
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> qu = new LinkedList<>();
        qu.offer(root);

        while(!qu.isEmpty()) {
            List<Integer> lst = new ArrayList<>();
            int len = qu.size();

            for(int i = 0; i < len; i++) {
                TreeNode curr = qu.poll();
                lst.add(curr.data);
                if(curr.left != null) {
                    qu.offer(curr.left);
                }
                if(curr.right != null) {
                    qu.offer(curr.right);
                }
            }
            ans.add(lst);
        }
        return ans;
    }
}