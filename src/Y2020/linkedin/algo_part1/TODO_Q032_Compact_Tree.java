package Y2020.linkedin.algo_part1;

import java.util.*;

public class TODO_Q032_Compact_Tree<T> {

    public Node<T> compact(Node<T> root, int N) {

        return null;
    }


    class Node<T> {
        private final T data;
        private final List<Node<T>> children;

        Node(T data, List<Node<T>> children) {
            this.data = data;
            this.children = children;
        }

        public T getData() {
            return data;
        }

        private List<Node<T>> getChildren() {
            return children;
        }
    }

}