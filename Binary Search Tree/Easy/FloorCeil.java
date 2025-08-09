package Binary Search Tree.Easy;
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

class FloorCeil {
    public List<Integer> floorCeilOfBST(TreeNode root, int key) {
        //your code goes here
        if(root == null) {
            return null;
        }
        int floor = Integer.MIN_VALUE;
        int ceil = Integer.MAX_VALUE;
        while(root != null) {
            if(root.data == key) {
                floor = root.data;
                ceil = root.data;
                break;
            }
            if(root.data < key) {
                floor = Math.max(floor, root.data);
                root = root.right;
            } else {
                ceil = Math.min(ceil, root.data);
                root = root.left;
            }
        }

        if (floor == Integer.MIN_VALUE) floor = -1;
        if (ceil == Integer.MAX_VALUE) ceil = -1;
        return List.of(floor, ceil);
    }
}