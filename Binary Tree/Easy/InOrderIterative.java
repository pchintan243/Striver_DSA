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

class InOrderIterative {
    public List<Integer> inorder(TreeNode root) {
        //your code goes here

        List<Integer> ans = new ArrayList<>();

        Stack<TreeNode> st = new Stack<>();
        TreeNode curr = root;
        while(true) {
            if(curr != null) {
                st.push(curr);
                curr = curr.left;
            } else {
                if(st.isEmpty())
                    break;
                curr = st.pop();
                ans.add(curr.data);
                curr = curr.right;
            }
        }
        

        return ans;
    }
}