package Binary Search Tree.Hard;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int data;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int val) { data = val; left = null, right = null }
 * }
 **/

class CorrectSwappedNodes {

    TreeNode prev, first, middle, last;

    void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        inorder(root.left);

        // Check for a violation of the BST property (current node is smaller than previous)
        if (prev != null && root.data < prev.data) {
            if (first == null) {
                // First violation found
                first = prev;
                middle = root;
            } else {
                // Second violation found
                last = root;
            }
        }
        
        // Update the previous node for the next comparison
        prev = root;
        inorder(root.right);
    }

    public void recoverTree(TreeNode root) {
        // Reset global pointers for a fresh traversal
        first = middle = last = null;
        prev = null;

        inorder(root);

        // Swap the identified nodes
        if (last != null) {
            // Case 1: Swapped nodes are not adjacent
            int temp = first.data;
            first.data = last.data;
            last.data = temp;
        } else {
            // Case 2: Swapped nodes are adjacent
            int temp = first.data;
            first.data = middle.data;
            middle.data = temp;
        }
    }
}