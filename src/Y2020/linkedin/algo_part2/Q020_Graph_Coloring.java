package Y2020.linkedin.algo_part2;

import java.util.*;

public class Q020_Graph_Coloring {

    boolean twoColorable(GraphNode node) {
        Queue<GraphNode> Q = new LinkedList<>();
        node.setColor(Color.RED);
        while (!Q.isEmpty()) {
            GraphNode curr = Q.poll();
            Color nextColor = curr.getColor() == Color.RED ? Color.BLUE : Color.RED;
            for (GraphNode next : curr.getNeighbors()) {
                if (next.getColor() == null) {
                    next.setColor(nextColor);
                    Q.add(next);
                } else {
                    if (next.getColor() == curr.getColor()) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    interface GraphNode {
        Set<GraphNode> getNeighbors();
        Color getColor();
        void setColor(Color c);
    }

    enum Color {
        RED,
        BLUE
    }
}
