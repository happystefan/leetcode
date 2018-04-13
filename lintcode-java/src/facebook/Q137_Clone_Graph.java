package facebook;

import java.util.*;

public class Q137_Clone_Graph {

    class UndirectedGraphNode {
        int label;
        ArrayList<UndirectedGraphNode> neighbors;
        UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
    }

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        Map<UndirectedGraphNode, UndirectedGraphNode> cloned = new HashMap<>();
        return cloneGraph(node, cloned);
    }

    private UndirectedGraphNode cloneGraph(UndirectedGraphNode node, Map<UndirectedGraphNode, UndirectedGraphNode> cloned) {
        if (node == null) {
            return null;
        }
        if (cloned.containsKey(node)) {
            return cloned.get(node);
        }
        UndirectedGraphNode result =  new UndirectedGraphNode(node.label);
        cloned.put(node, result);
        for (int i = 0; i < node.neighbors.size(); i++) {
            result.neighbors.add(i, cloneGraph(node.neighbors.get(i), cloned));
        }
        return result;
    }

}
