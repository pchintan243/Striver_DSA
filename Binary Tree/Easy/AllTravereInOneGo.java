import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
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
    int state;
    TreeNode node;
    Node(TreeNode node, int val) {
        this.state = val;
        this.node = node;
    }
}
class AllTravereInOneGo {
    
    List<List<Integer>> treeTraversal(TreeNode root) {
        //your code goes here
        if(root == null)
            return List.of();
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> inOrder = new ArrayList<>();
        List<Integer> preOrder = new ArrayList<>();
        List<Integer> postOrder = new ArrayList<>();

        Stack<Node> st = new Stack<>();
        st.add(new Node(root, 1));
        while(!st.isEmpty()) {
            Node n = st.pop();
            TreeNode curr = n.node;
            int state = n.state;
            if(state == 1) {
                preOrder.add(curr.data);
                st.add(new Node(curr, 2));
                if(curr.left != null) {
                    st.add(new Node(curr.left, 1));
                }
            } else if(state == 2) {
                inOrder.add(curr.data);
                st.add(new Node(curr, 3));
                if(curr.right != null) {
                    st.add(new Node(curr.right, 1));
                }
            } else {
                postOrder.add(curr.data);
            }
        }
        ans.addAll(List.of(inOrder, preOrder, postOrder));
        return ans;
    }
}