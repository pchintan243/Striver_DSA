/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int data;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int val) { data = val; left = null, right = null }
 * }
 **/

class CheckTwoTreesSameBruteForce {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        //your code goes here
        if(p.data != q.data) {
            return false;
        }
        TreeNode currp = p;
        TreeNode currq = q;
        Queue<TreeNode> qup = new LinkedList<>();
        Queue<TreeNode> quq = new LinkedList<>();

        qup.offer(p);
        quq.offer(q);

        while(!qup.isEmpty() || !quq.isEmpty()) {
            if(qup.size() != quq.size()) {
                return false;
            }
            int n = qup.size();
            for(int i = 0; i < n; i++) {
                currp = qup.poll();
                currq = quq.poll();

                if((currp.left == null && currq.left != null) ||
                (currp.left != null && currq.left == null)) {
                    return false;
                } else if((currp.left != null && currq.left != null) && (currp.left.data != currq.left.data)) {
                    return false;
                }
                if((currp.right == null && currq.right != null) ||
                (currp.right != null && currq.right == null)) {
                    return false;
                } else if((currp.right != null && currq.right != null) && (currp.right.data != currq.right.data)) {
                    return false;
                }

                if(currp.right != null) {
                    qup.offer(currp.right);
                }
                if(currq.right != null) {
                    quq.offer(currq.right);
                }

                if(currp.left != null) {
                    qup.offer(currp.left);
                }
                if(currq.left != null) {
                    quq.offer(currq.left);
                }
            }

        }

        return true;
    }
}