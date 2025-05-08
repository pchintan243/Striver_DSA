import java.util.ArrayList;
import java.util.List;

public /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int data;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int val) { data = val; left = null, right = null }
 * }
 **/

class RightViewRecursive {
    public void rightView(TreeNode root, int level, List<Integer> ans) {
        if(root == null)
            return;
        if(level == ans.size()) {
            ans.add(root.data);
        }

        rightView(root.right, level + 1, ans);
        rightView(root.left, level + 1, ans);
    }
    public List<Integer> rightSideView(TreeNode root) {
        //your code goes here

        if(root == null) {
            return List.of();
        }
        List<Integer> ans = new ArrayList<>();

        rightView(root, 0, ans);
        return ans;
    }
} {
    
}
