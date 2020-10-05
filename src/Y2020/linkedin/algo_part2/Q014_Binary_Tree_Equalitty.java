package Y2020.linkedin.algo_part2;

public class Q014_Binary_Tree_Equalitty {

    interface Node {
        Object getValue();
        Node getLeft();
        Node getRight();
    }

    boolean compare(Node a, Node b) {
        if (a == null && b == null) return true;
        if (a == null && b != null || a != null && b == null) return false;
        return a.getValue().equals(b.getValue()) && compare(a.getLeft(), b.getRight());
    }

}
