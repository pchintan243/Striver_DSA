import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
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
class PostOrder2Stack {
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root == null) 
            return List.of();

        TreeNode curr = root;
        List<Integer> ans = new ArrayList<>();

        Stack<TreeNode> st = new Stack<>();
        Stack<TreeNode> temp = new Stack<>();
        st.add(curr);

        while(!st.isEmpty()) {
            curr = st.pop();
            temp.add(curr);
            if(curr.left != null)
                st.add(curr.left);
            if(curr.right != null)
                st.add(curr.right);
        }
        while(!temp.isEmpty()) {
            ans.add(temp.pop().val);
        }
        return ans;
    }
}