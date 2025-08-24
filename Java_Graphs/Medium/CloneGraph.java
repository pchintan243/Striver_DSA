package Java_Graphs.Medium;
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/
public class CloneGraph {
    Map<Node, Node> clonedMap = new HashMap<>();
    public Node cloneGraph(Node node) {
        // Base case: if the node is null, there is nothing to clone
        if (node == null) {
            return null;
        }

        // If we have already cloned this node, return the existing clone
        if (clonedMap.containsKey(node)) {
            return clonedMap.get(node);
        }

        // Create a new clone for the current node
        Node clone = new Node(node.val);
        clonedMap.put(node, clone);

        // Recursively clone the neighbors and build the connections in the new graph
        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(cloneGraph(neighbor));
        }
        return clone;

    }
}