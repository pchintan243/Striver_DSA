/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int data;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int val) { data = val; left = null, right = null }
 * }
 **/

class CheckTwoTreeSameRecursive {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        //your code goes here
        if(p == null || q == null) {
            return p == q;
        }

        return (p.data == q.data) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}