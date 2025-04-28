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

class PreOrderRecursive {
    public void traverse(TreeNode root, List<Integer> ans) {
        if(root == null)
            return;
        ans.add(root.data);
        traverse(root.left, ans);
        traverse(root.right, ans);
    }
    public List<Integer> preorder(TreeNode root) {
        //your code goes here
        List<Integer> ans = new ArrayList<>();

        traverse(root, ans);
        return ans;
    }
}