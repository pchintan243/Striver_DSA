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
class Node {
    TreeNode node;
    int level;
    Node(TreeNode node, int level) {
        this.node = node;
        this.level = level;
    }
}

class RightView {
    public List<Integer> rightSideView(TreeNode root) {
        //your code goes here

        if(root == null) {
            return List.of();
        }
        List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()) {
            int len = q.size();
            TreeNode curr = null;
            for(int i = 0; i < len; i++) {
                curr = q.poll();

                if(curr.left != null) {
                    q.offer(curr.left);
                }
                if(curr.right != null) {
                    q.offer(curr.right);
                }
            }
            if(curr != null) {
                ans.add(curr.data);
            }
        }

        return ans;
    }
}