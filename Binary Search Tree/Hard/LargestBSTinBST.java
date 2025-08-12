package Binary Search Tree.Hard;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int data;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int val) { data = val; left = null, right = null }
 * }
 **/

class NodeInfo {
    public int min, max, size;

    NodeInfo(int minNode, int maxNode, int size) {
        this.min = minNode;
        this.max = maxNode;
        this.size = size;
    }
}
class LargestBSTinBST {
        NodeInfo recursion(TreeNode root) {
            if(root == null) {
                return new NodeInfo(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
            }
            NodeInfo left = recursion(root.left);
            NodeInfo right = recursion(root.right);

            if(left.max < root.data && root.data < right.min) {
                return new NodeInfo(Math.min(root.data, left.min), Math.max(root.data, right.max), left.size + right.size + 1);
            }

            return new NodeInfo(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.size, right.size));
        }
        public int largestBST(TreeNode root) {
            //your code goes here
            NodeInfo ans = recursion(root);
            return ans.size;
        }
}