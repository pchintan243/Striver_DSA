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

class DeleteNode {
    public TreeNode deleteNode(TreeNode root, int key) {
        //your code goes here
        if(root == null) {
            return root;
        }
        if(root.data == key) {
            return helper(root);
        }

        TreeNode curr = root;
        while(root != null) {
            if(root.data > key) {
                if(root.left != null && root.left.data == key) {
                    root.left = helper(root.left);
                    break;
                } else {
                    root = root.left;
                }
            } else {
                if(root.right != null && root.right.data == key) {
                    root.right = helper(root.right);
                    break;
                } else {
                    root = root.right;
                }
            }
        }
        return curr;
    }

    public TreeNode helper(TreeNode root) {
        if(root.left == null) {
            return root.right;
        } else if(root.right == null) {
            return root.left;
        } else {
            TreeNode rightChild = root.right;
            TreeNode lastRight = findLastRight(root.left);
            lastRight.right = rightChild;
            return root.left;
        }
    }

    public TreeNode findLastRight(TreeNode root) {
        if(root.right == null) {
            return root;
        }

        return findLastRight(root.right);
    }
}