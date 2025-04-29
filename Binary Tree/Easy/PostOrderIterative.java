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

class PostOrderIterative {
    public List<Integer> postorder(TreeNode root) {
        //your code goes here
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();

        TreeNode curr = root;
        st.push(curr);
        while(!st.isEmpty()) {
            curr = st.pop();
            ans.add(curr.data);
            if(curr.left != null) {
                st.push(curr.left);
            }
            if(curr.right != null) {
                st.push(curr.right);
            }
        }
        Collections.reverse(ans);
        return ans;
    }
}