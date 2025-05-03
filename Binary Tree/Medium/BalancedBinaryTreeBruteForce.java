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
class BalancedBinaryTreeBruteForce {

    public int findHeight(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int height = 0;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()) {
            int n = q.size();

            for(int i = 0; i < n; i++) {
                TreeNode curr = q.poll();
                if(curr.right != null) {
                    q.offer(curr.right);
                }

                if(curr.left != null) {
                    q.offer(curr.left);
                }
            }

            height++;
        }

        return height;
    }
    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        Stack<TreeNode> st = new Stack<>();
        st.add(root);
        while(!st.isEmpty()) {
            TreeNode curr = st.pop();
            if(curr.right != null) {
                st.add(curr.right);
            }
            if(curr.left != null) {
                st.add(curr.left);
            }
            int leftCnt = findHeight(curr.left);
            int rightCnt = findHeight(curr.right);

            if(Math.abs(leftCnt - rightCnt) > 1) {
                return false;
            }
        }

        return true;
    }
}