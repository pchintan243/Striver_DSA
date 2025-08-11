package Binary Search Tree.Hard;
import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int data;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int val) { data = val; left = null, right = null }
 * }
 **/

class TwoSumBST {
    void pushSmaller(TreeNode root, Stack<TreeNode> st) {
        if(root == null) {
            return;
        }
        st.push(root);
        pushSmaller(root.left, st);
    }

    void pushHigher(TreeNode root, Stack<TreeNode> st) {
        if(root == null) {
            return;
        }
        st.push(root);
        pushHigher(root.right, st);
    }
    
    public boolean twoSumBST(TreeNode root, int k) {
        //your code goes here
        Stack<TreeNode> smaller = new Stack<>();
        Stack<TreeNode> higher = new Stack<>();
        pushSmaller(root, smaller);
        pushHigher(root, higher);

        while(root != null) {
            int first = smaller.peek().data;
            int second = higher.peek().data;
            if(first == second) {
                return false;
            }

            int sum = first + second;
            if(sum == k) {
                return true;
            } else if(sum < k) {
                TreeNode small = smaller.pop();
                pushSmaller(small.right, smaller);
            } else {
                TreeNode high = higher.pop();
                pushHigher(high.left, higher);
            }
        }

        return false;
    }
}