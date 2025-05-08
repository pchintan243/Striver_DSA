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
    int level;
    Node(TreeNode node, int vertical, int level) {
        this.node = node;
        this.vertical = vertical;
        this.level = level;
    }
}

class VerticalOrderTraversal {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        //your code goes here
        if(root == null) {
            return List.of();
        }
        List<List<Integer>> ans = new ArrayList<>();
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> mp = new TreeMap<>();

        Queue<Node> q = new LinkedList<>();

        q.offer(new Node(root, 0, 0));
        
        while(!q.isEmpty()) {
            Node temp = q.poll();
            TreeNode curr = temp.node;
            int vertical = temp.vertical;
            int level = temp.level;

            mp.putIfAbsent(vertical, new TreeMap<>());
            mp.get(vertical).putIfAbsent(level, new PriorityQueue<>());
            mp.get(vertical).get(level).offer(curr.data);

            if(curr.left != null) {
                q.offer(new Node(curr.left, temp.vertical - 1, temp.level + 1));
            }

            if(curr.right != null) {
                q.offer(new Node(curr.right, temp.vertical + 1, temp.level + 1));
            }
        }

        for(TreeMap<Integer, PriorityQueue<Integer>> data : mp.values()) {
            List<Integer> lst = new ArrayList<>();

            for(PriorityQueue<Integer> pq : data.values()) {
                while(!pq.isEmpty()) {
                    lst.add(pq.poll());
                }
            }

            ans.add(lst);
        }

        return ans;
    }   
}