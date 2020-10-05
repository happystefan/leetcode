package Y2020.linkedin.algo_part2;

import java.util.Collection;
import java.util.HashMap;

public class QQ034_Clone_Object_Graph {


    public Node cloneGraph(Node root) {
        return cloneGraph(root, new HashMap<Node, Node>());
    }

    private Node cloneGraph(Node root, HashMap<Node, Node> map) {
        if (map.containsKey(root)) return map.get(root);
        Node newNode = root.copyNode();
        map.put(root, newNode);
        for (Node child : root.getChildren()) {
            newNode.addChild(cloneGraph(child, map));
        }
        return newNode;
    }

    interface Node {
        Node copyNode();
        Collection<Node> getChildren();
        void addChild(Node child);
        int getNumOfParents();
    }


}
