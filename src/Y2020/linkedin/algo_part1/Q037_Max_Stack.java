package Y2020.linkedin.algo_part1;

import java.util.*;

public class Q037_Max_Stack {

    interface MaxStack<T extends Comparable<T>> {
        void push(T item);
        T peek();
        T pop();
        T peekMax();
        T popMax();
    }

    class Node<T> {
        Node<T> prev;
        Node<T> next;
        T val;
        public Node (T val) {
            this.val = val;
        }
    }

    class stack<T extends Comparable<T>> implements MaxStack<T> {

        Node<T> dummy = new Node(0);
        TreeMap<T, List<Node>> map = new TreeMap<>();
        T max = null;

        @Override
        public void push(T val) {
            Node<T> node = new Node<>(val);
            node.next = dummy.next;
            node.prev = dummy;
            dummy.next = node;
            map.computeIfAbsent(val, k->new LinkedList<>()).add(0, node);
            if (max == null || max.compareTo(val) < 0) {
                max = val;
            }
        }

        @Override
        public T peek() {
            if (dummy.next == null) {
                return null;
            }
            return dummy.next.val;
        }

        @Override
        public T pop() {
            if (dummy.next == null) {
                return null;
            }
            T val = dummy.next.val;
            dummy.next.next.prev = dummy;
            dummy.next = dummy.next.next;
            map.get(val).remove(0);
            if (map.get(val).size() == 0) map.remove(val);
            if (val.compareTo(max) == 0) {
                max = map.isEmpty() ? null : map.lastKey();
            }
            return val;
        }

        @Override
        public T peekMax() {
            return max;
        }

        @Override
        public T popMax() {
            Node node = map.get(max).get(0);
            map.get(max).remove(0);
            if (map.get(max).size() == 0) {
                map.remove(node.val);
                max = map.isEmpty() ? null : map.lastKey();
            }

            if (node.next != null) {
                node.next.prev = node.prev;
            }
            node.prev.next = node.next;

            return (T) node.val;
        }
    }
}
