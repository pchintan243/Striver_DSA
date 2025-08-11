/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int data;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int val) { data = val; left = null, right = null }
 * }
 **/

class PreOrderToBST {
    private int ind = 0;
    TreeNode dfs(int[] preorder, int min, int max) {
        
        if(ind == preorder.length || preorder[ind] <= min || preorder[ind] >= max) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[ind]);
        ind++;

        root.left = dfs(preorder, min, root.data);
        root.right = dfs(preorder, root.data, max);
        return root;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        //your code goes here
        return dfs(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}