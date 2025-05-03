/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int data;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int val) { data = val; left = null, right = null }
 * }
 **/

class HeightOfTreeIterative {
    public int maxDepth(TreeNode root) {
        //your code goes here
        //your code goes here
        if(root == null)
            return 0;
        Queue<TreeNode> qu = new LinkedList<>();
        qu.offer(root);
        int ans = 0;

        while(!qu.isEmpty()) {
            int len = qu.size();

            for(int i = 0; i < len; i++) {
                TreeNode curr = qu.poll();
                if(curr.left != null) {
                    qu.offer(curr.left);
                }
                if(curr.right != null) {
                    qu.offer(curr.right);
                }
            }
            ans++;
        }
        return ans;
    }
}