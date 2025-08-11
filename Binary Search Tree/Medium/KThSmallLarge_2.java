package Binary Search Tree.Medium;
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

class KThSmallLarge_2 {
    void inOrderTraversal(TreeNode root, int k, List<Integer> inOrder) {
        if(root == null) {
            return;
        }

        inOrderTraversal(root.left, k, inOrder);
        inOrder.add(root.data);
        inOrderTraversal(root.right, k, inOrder);
    }
    
    public List<Integer> kLargesSmall(TreeNode root, int k) {
        //your code goes here
        List<Integer> ans = new ArrayList<>();
        inOrderTraversal(root, k, ans);
        int n = ans.size();

        return List.of(ans.get(k - 1), ans.get(n - k));
    }
}