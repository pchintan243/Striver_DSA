package Binary Search Tree.Medium;
import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node. public class TreeNode { int data; TreeNode left; TreeNode
 * right; TreeNode(int val) { data = val; left = null, right = null } }
 */
class PreFixSuffixBST {
    int findLeftMost(TreeNode root) {
        if(root.left == null) {
            return root.data;
        }
        return findLeftMost(root.left);
    }

    int findRightMost(TreeNode root) {
        if(root.right == null) {
            return root.data;
        }
        return findRightMost(root.right);
    }
    List<Integer> succPredBST(TreeNode root, int key) {
        // your code goes here
        List<Integer> ans = new ArrayList<>();
        ans.add(-1);
        ans.add(-1);

        while (root != null) {
            if (root.data < key) {
                ans.set(0, root.data);
                root = root.right;
            } else if (root.data > key) {
                ans.set(1, root.data);
                root = root.left;
            } else {
                if(root.left != null) {
                    int min = findRightMost(root.left);
                    ans.set(0, min);
                }

                if(root.right != null) {
                    int max = findLeftMost(root.right);
                    ans.set(1, max);
                }
                break;
            }
        }
        return ans;
    }
}
