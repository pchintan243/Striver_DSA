package Binary Search Tree.Medium;
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

class KthSmallLarge {

    private int kSmallestCounter;
    private int kSmallestResult;
    private int kLargestCounter;
    private int kLargestResult;

    void inOrderForSmall(TreeNode root, int k) {
        if(root == null || kSmallestResult != -1) {
            return;
        }
        
        inOrderForSmall(root.left, k);
        if(kSmallestResult == -1) {
            kSmallestCounter++;
            if(kSmallestCounter == k) {
                kSmallestResult = root.data;
            }
        }
        inOrderForSmall(root.right, k);
    }
    void inOrderForLarge(TreeNode root, int k) {
        if(root == null || kLargestResult != -1) {
            return;
        }
        
        inOrderForLarge(root.right, k);
        if(kLargestResult == -1) {
            kLargestCounter++;
            if(kLargestCounter == k) {
                kLargestResult = root.data;
            }
        }
        inOrderForLarge(root.left, k);
    }

    
    public List<Integer> kLargesSmall(TreeNode root, int k) {
        //your code goes here
        kSmallestCounter = 0;
        kSmallestResult = -1;
        inOrderForSmall(root, k);

        kLargestCounter = 0;
        kLargestResult = -1;
        inOrderForLarge(root, k);
        
        return List.of(kSmallestResult, kLargestResult);
    }
}