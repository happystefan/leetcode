package archive.graph;

import java.util.*;

public class Q133_Clone_Graph {

    class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;
        UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
    }

    Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        return clone(node);
    }

    private UndirectedGraphNode clone(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        if (map.containsKey(node)) {
            return map.get(node);
        }
        UndirectedGraphNode peer = new UndirectedGraphNode(node.label);
        map.put(node, peer);
        for (UndirectedGraphNode neighbor : node.neighbors) {
            peer.neighbors.add(clone(neighbor));
        }
        return peer;
    }

}
