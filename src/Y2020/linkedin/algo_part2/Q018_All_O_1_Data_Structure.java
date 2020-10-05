package Y2020.linkedin.algo_part2;

import java.util.*;

public class Q018_All_O_1_Data_Structure {

    interface AllForOne {
        void incrementKey(String key);

        void decrementKey(String key);

        String getMaxKey();

        String getMinKey();
    }

    class AllForOneImpl implements AllForOne {

        Map<String, Node> map = new HashMap<>();
        Node head = new Node(-1);
        Node tail = new Node(-1);

        public AllForOneImpl() {
            head.next = tail;
            tail.prev = head;
        }

        @Override
        public void incrementKey(String key) {
            if (!map.containsKey(key)) {
                Node node = head.next;
                while (node != tail) {
                    if (node.freq >= 1) break;
                    node = node.next;
                }
                if (node.freq > 1) {
                    Node newNode = new Node(1);
                    newNode.keys.add(key);
                    addNode(newNode, head, head.next);
                    map.put(key, newNode);
                } else {
                    node.keys.add(key);
                    map.put(key, node);
                }
            } else {
                Node node = map.get(key);
                node.keys.remove(key);

                if (node.next.freq == node.freq + 1) {
                    node.next.keys.add(key);
                    map.put(key, node.next);
                } else {
                    Node newNode = new Node(node.freq + 1);
                    newNode.keys.add(key);
                    addNode(newNode, node, node.next);
                    map.put(key, newNode);
                }

                if (node.keys.isEmpty()) {
                    delNode(node);
                }
            }
        }

        @Override
        public void decrementKey(String key) {
            if (!map.containsKey(key)) return;
            Node node = map.get(key);
            if (node.freq == 1) {
                node.keys.remove(key);
                map.remove(key);
                if (node.keys.isEmpty()) {
                    delNode(node);
                }
            } else {
                node.keys.remove(key);
                if (node.prev.freq == node.freq - 1) {
                    node.prev.keys.add(key);
                    map.put(key, node.prev);
                } else {
                    Node newNode = new Node(node.freq - 1);
                    newNode.keys.add(key);
                    addNode(newNode, node.prev, node);
                    map.put(key, newNode);
                }
            }
        }

        private void addNode(Node node, Node prev, Node next) {
            node.prev = prev;
            node.next = next;
            prev.next = node;
            next.prev = node;
        }

        private void delNode(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        @Override
        public String getMaxKey() {
            if (tail.prev == head.next) {
                throw new IllegalCallerException();
            }
            return new ArrayList<>(tail.prev.keys).get(0);
        }

        @Override
        public String getMinKey() {
            if (tail.prev == head.next) {
                throw new IllegalCallerException();
            }
            return new ArrayList<>(head.next.keys).get(0);
        }
    }

    class Node {
        Node prev;
        Node next;
        Set<String> keys = new HashSet<>();
        int freq;

        public Node(int freq) {
            this.freq = freq;
        }
    }
}
