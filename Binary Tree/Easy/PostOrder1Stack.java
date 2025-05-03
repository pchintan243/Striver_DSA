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
class PostOrder1Stack {
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root == null) 
            return List.of();

        TreeNode curr = root;
        List<Integer> ans = new ArrayList<>();

        Stack<TreeNode> st = new Stack<>();

        while(curr != null || !st.isEmpty()) {
            if(curr != null) {
                st.add(curr);
                curr = curr.left;
            } else {
                TreeNode temp = st.peek().right;
                if(temp == null) {
                    temp = st.pop();
                    ans.add(temp.val);

                    while(!st.isEmpty() && (temp == st.peek().right)) {
                        temp = st.pop();
                        ans.add(temp.val);
                    }
                } else {
                    curr = temp;
                }
            }
        }
        return ans;
    }
}