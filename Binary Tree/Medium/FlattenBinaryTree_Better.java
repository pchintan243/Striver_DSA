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
public class FlattenBinaryTree_Better {
    private boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }
    public void flatten(TreeNode root) {
        if(root == null) {
            return;
        }
        Stack<TreeNode> st = new Stack<>();
        
        while(!isLeaf(root) || !st.isEmpty()) {
            if(root.left != null) {
                if(root.right != null)
                    st.push(root.right);
                root.right = root.left;
                root.left = null;
                root = root.right;
                continue;
            }
            if(root.right != null) {
                root = root.right;
                continue;
            }
            if(!st.isEmpty()) {
                root.right = st.pop();
                root = root.right;
            }
        }

    }
}