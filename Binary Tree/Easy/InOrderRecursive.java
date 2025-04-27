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

class InOrderRecursive {

    public void traverse(TreeNode root, List<Integer> ans) {
        if(root == null)
            return;
        traverse(root.left, ans);
        ans.add(root.data);
        traverse(root.right, ans);
    }
    public List<Integer> inorder(TreeNode root) {
        //your code goes here
        List<Integer> ans = new ArrayList<>();

        traverse(root, ans);
        return ans;
    }
}