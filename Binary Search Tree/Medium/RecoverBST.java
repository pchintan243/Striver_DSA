package Binary Search Tree.Medium;

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
public class RecoverBST {
    TreeNode first;
    TreeNode prev;
    TreeNode middle;
    TreeNode last;
    void inorder(TreeNode root) {
        if(root == null) {
            return;
        }
        inorder(root.left);
        if(root.val < prev.val) {
            if(first == null) {
                first = prev;
                middle = root;
            } else {
                last = root;
            }
        }
        prev = root;
        inorder(root.right);
    }
    public void recoverTree(TreeNode root) {
        first = null;
        middle = null;
        last = null;
        prev = new TreeNode(Integer.MIN_VALUE);

        inorder(root);
        if(last != null) {
            int temp = last.val;
            last.val = first.val;
            first.val = temp;
        } else if(first != null) {
            int temp = middle.val;
            middle.val = first.val;
            first.val = temp;
        }

    }   
}