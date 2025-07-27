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

class NextRightPointerAssign-II {
    private boolean isLeafNode(Node curr) {
        return curr.left == null && curr.right == null;
    }

    private Node getRightNode(Node curr) {
        Node temp = curr;
        while(temp != null) {
            if(temp.left != null) {
                return temp.left;
            } else if(temp.right != null) {
                return temp.right;
            }
            temp = temp.next;
        }

        return null;
    }
    private void dfs(Node curr) {
        if(curr == null) {
            return;
        }
        if(isLeafNode(curr)) {
            return;
        }
        if(curr.left != null && curr.right != null) {
            curr.left.next = curr.right;
        }
        Node nextNode = null;
        if(curr.right != null) {
            nextNode = curr.right;
        } else if(curr.left != null) {
            nextNode = curr.left;
        }
        if(nextNode != null && curr.next != null) {
            Node temp = getRightNode(curr.next);
            nextNode.next = temp;
        }
        dfs(curr.right);
        dfs(curr.left);
    }
    public Node connect(Node root) {
        if(root == null) {
            return root;
        }
        dfs(root);
        return root;
    }
}