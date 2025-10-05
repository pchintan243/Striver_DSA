package Binary Search Tree.Medium;
import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class AllElementsTwoBST {
    void inorder(TreeNode root, List<Integer> lst) {
        if(root == null) {
            return;
        }
        inorder(root.left, lst);
        lst.add(root.val);
        inorder(root.right, lst);
    }
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> lst1 = new ArrayList<>();
        List<Integer> lst2 = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();

        inorder(root1, lst1);
        inorder(root2, lst2);

        int i = 0;
        int j = 0;
        int n = lst1.size();
        int m = lst2.size();
        while(i < n && j < m) {
            if(lst1.get(i) < lst2.get(j))
                ans.add(lst1.get(i++));
            else
                ans.add(lst2.get(j++));
        }
        while(i < n) {
            ans.add(lst1.get(i++));
        }

        while(j < m) {
            ans.add(lst2.get(j++));
        }
        return ans;
    }
}