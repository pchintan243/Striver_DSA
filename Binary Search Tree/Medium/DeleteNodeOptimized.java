package Binary Search Tree.Medium;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int data;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int val) { data = val; left = null, right = null }
 * }
 **/

class DeleteNodeOptimized {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return root;
        }
        
        // Traverse to find the node to delete
        if (key < root.data) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.data) {
            root.right = deleteNode(root.right, key);
        } else { // Found the node to delete
            
            // Case 1: Node has no left child or is a leaf
            if (root.left == null) {
                return root.right;
            } 
            
            // Case 2: Node has no right child
            if (root.right == null) {
                return root.left;
            }
            
            // Case 3: Node has two children
            // Find the in-order successor (smallest node in the right subtree)
            TreeNode successor = findMinNode(root.right);
            
            // Replace the current node's data with the successor's data
            root.data = successor.data;
            
            // Delete the successor from the right subtree
            root.right = deleteNode(root.right, successor.data);
        }
        
        return root;
    }

    // Helper to find the minimum value node in a subtree
    private TreeNode findMinNode(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}