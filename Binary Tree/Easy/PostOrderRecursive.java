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

class PostOrderRecursive {
    public void traverse(TreeNode root, List<Integer> ans) {
        if(root == null)
            return;
        traverse(root.left, ans);
        traverse(root.right, ans);
        ans.add(root.data);
    }
    public List<Integer> postorder(TreeNode root) {
        //your code goes here
        List<Integer> ans = new ArrayList<>();

        traverse(root, ans);
        return ans;
    }
}