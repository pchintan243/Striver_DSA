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

class BSTIterator {
        Stack<TreeNode> st = new Stack<>();
        public BSTIterator(TreeNode root) {
            constructBST(root);
        }

        public boolean hasNext() {
            return !st.isEmpty();
        }

        public int next() {
            TreeNode node = st.pop();
            if(node.right != null) {
                constructBST(node.right);
            }
            return node.data;
        }

        void constructBST(TreeNode curr) {
            if(curr == null) {
                return;
            }
            st.push(curr);
            constructBST(curr.left);
        }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */