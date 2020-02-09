package Y2019.Q0001_Q0300;

import java.util.*;

public class Q0133_Clone_Graph {

    Map<Node, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (map.containsKey(node)) return map.get(node);
        Node newNode = new Node();
        newNode.val = node.val;
        newNode.neighbors = new ArrayList<>(node.neighbors.size());
        map.put(node, newNode);
        for (Node neighbor : node.neighbors) {
            newNode.neighbors.add(cloneGraph(neighbor));
        }
        return newNode;
    }

    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
        }

        public Node(int _val, List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

}
