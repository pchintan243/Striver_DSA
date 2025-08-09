package Binary Search Tree.Easy;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int data;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int val) { data = val; left = null, right = null }
 * }
 **/

class SearchInBST {
    TreeNode search(TreeNode curr, int val) {
        if(curr == null || curr.data == val)
            return curr;
        if(curr.data > val) {
            return search(curr.left, val);
        } else {
            return search(curr.right, val);
        }
    }
    public TreeNode searchBST(TreeNode root, int val) {
        //your code goes here
        TreeNode curr = root;
        return search(curr, val);
    }
}