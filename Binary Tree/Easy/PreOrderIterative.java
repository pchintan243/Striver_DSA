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

class PreOrderIterative {
    public List<Integer> preorder(TreeNode root) {
        //your code goes here
        Stack<TreeNode> st = new Stack<>();
        if(root == null) {
            return List.of();
        }
        TreeNode curr = root;
        List<Integer> ans = new ArrayList<>();
        st.push(curr);
        
        while(!st.isEmpty()) {
            curr = st.pop();
            ans.add(curr.data);
            if(curr.right != null) {
                st.push(curr.right);
            }
            if(curr.left != null) {
                st.push(curr.left);
            }
        }
        return ans;
    }
}