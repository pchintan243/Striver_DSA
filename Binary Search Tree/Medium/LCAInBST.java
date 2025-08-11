package Binary Search Tree.Medium;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int data;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int val) { data = val; left = null, right = null }
 * }
 **/

class LCAInBST {
    TreeNode find(TreeNode root, int p, int q) {
        if(root == null) {
            return null;
        }

        if(root.data < p && root.data < q) {
            return find(root.right, p, q);
        } 
        if(root.data > p && root.data > q) {
            return find(root.left, p, q);
        }

        return root;
    }
    public TreeNode lca(TreeNode root, int p, int q) {
        //your code goes here

        if(root == null) {
            return root;
        }
        return find(root, p, q);
    }
}