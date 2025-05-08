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

class BoundaryTraversal {
    public boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }

    public void addLeftBoundary(TreeNode root, List<Integer> ans) {
        TreeNode curr = root.left;
        while(curr != null) {
            if(!isLeaf(curr)) {
                ans.add(curr.data);
            }
            if(curr.left != null) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
    }

    public void addRightBoundary(TreeNode root, List<Integer> ans) {
        TreeNode curr = root.right;
        LinkedList<Integer> temp = new LinkedList<>();
        while(curr != null) {
            if(!isLeaf(curr)) {
                temp.addFirst(curr.data);
            }
            if(curr.right != null) {
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }
        ans.addAll(temp);
    }

    public void addLeafNodes(TreeNode root, List<Integer> ans) {
        if(isLeaf(root)) {
            ans.add(root.data);
            return;
        }
        if(root.left != null) {
            addLeafNodes(root.left, ans);
        }
        if(root.right != null) {
            addLeafNodes(root.right, ans);
        }
    }

    public List<Integer> boundary(TreeNode root) {
        //your code goes here
        if(root == null) {
            return List.of();
        }

        List<Integer> ans = new ArrayList<>();

        if(!isLeaf(root)) {
            ans.add(root.data);
        }

        addLeftBoundary(root, ans);
        addLeafNodes(root, ans);
        addRightBoundary(root, ans);

        return ans;
    }
}