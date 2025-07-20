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
public class FlattenBinaryTree_Optimal {
    public void flatten(TreeNode root) {
        flat(root);
    }
    public TreeNode flat( TreeNode root){
        if(root == null)return null; 
        if(root.left == null && root.right == null)return root; 
        TreeNode leftTail = flat(root.left);
        TreeNode rightTail = flat(root.right);

        if(root.left !=null){
            TreeNode rightTemp = root.right; 
            root.right = root.left; 
            root.left = null; 
            leftTail.right = rightTemp; 
            
        }
        if(rightTail==null){
            if(leftTail==null)return root; 
            else return leftTail; 
        }
        return rightTail; 

    }
}