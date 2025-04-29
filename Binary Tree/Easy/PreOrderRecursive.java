import java.util.ArrayList;
import java.util.List;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int data;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int val) { data = val; left = null, right = null }
 * }
 **/

class SolutiPreOrderRecursiveon {
    public void recursivePreOrder(TreeNode node, List<Integer> ans) {
        if(node == null) 
            return;
        ans.add(node.data);
        recursivePreOrder(node.left, ans);
        recursivePreOrder(node.right, ans);
    }
    public List<Integer> preorder(TreeNode root) {
        //your code goes here

        List<Integer> ans = new ArrayList<>();
        recursivePreOrder(root, ans);
        return ans;
    }
}