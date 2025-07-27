package Binary Tree.Medium;

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class NextRightPointerAssign {
    private boolean isLeafNode(Node curr) {
        return curr.left == null && curr.right == null;
    }
    private void dfs(Node curr) {
        if(curr == null) {
            return;
        }
        if(isLeafNode(curr)) {
            return;
        }
        if(!isLeafNode(curr)) {
            curr.left.next = curr.right;
            if(curr.next != null) {
                curr.right.next = curr.next.left;
            }
        }
        dfs(curr.left);
        dfs(curr.right);
    }
    public Node connect(Node root) {
        if(root == null) {
            return root;
        }
        dfs(root);
        // Queue<Node> q = new LinkedList<>();

        // q.offer(root);

        // while(!q.isEmpty()) {
        //     int n = q.size();

        //     for(int i = 0; i < n; i++) {
        //         Node prevNode = q.poll();
        //         prevNode.next = i == n - 1 ? null : q.peek();
        //         if(prevNode.left != null) {
        //             q.offer(prevNode.left);
        //             q.offer(prevNode.right);
        //         }
        //     }
        // }
        return root;
    }
}