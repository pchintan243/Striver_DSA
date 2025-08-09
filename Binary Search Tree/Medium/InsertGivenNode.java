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

class public class InsertGivenNode {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        //your code goes here
        TreeNode newNode = new TreeNode(val);
        if(root == null) {
            return newNode;
        }
        TreeNode curr = root;
        TreeNode prev = null;

        while(curr != null) {
            if(curr.data <= val) {
                if(curr.right != null) {
                    curr = curr.right;
                } else {
                    curr.right = newNode;
                    break;
                }
            } else {
                if(curr.left != null) {
                    curr = curr.left;
                } else {
                    curr.left = newNode;
                    break;
                }
            }
        }
        return root;
    }
}