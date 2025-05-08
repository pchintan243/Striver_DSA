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
    int vertical;
    Node(TreeNode node, int vertical) {
        this.node = node;
        this.vertical = vertical;
    }
}
class BottomViewOfBT {
    public List<Integer> bottomView(TreeNode root) {
        //your code goes here
        if(root == null) {
            return List.of();
        }
        TreeMap<Integer, Integer> mp = new TreeMap<>();
        List<Integer> ans = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(root, 0));

        while(!q.isEmpty()) {
            Node temp = q.poll();
            TreeNode curr = temp.node;
            int vertical = temp.vertical;
            
            mp.put(vertical, curr.data);
            if(curr.left != null) {
                q.offer(new Node(curr.left, vertical - 1));
            }

            if(curr.right != null) {
                q.offer(new Node(curr.right, vertical + 1));
            }
        }
        ans.addAll(mp.values());

        return ans;
    }
}