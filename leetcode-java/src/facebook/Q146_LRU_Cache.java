package facebook;

import java.util.*;

public class Q146_LRU_Cache {

    class LRUCache {

        Map<Integer, DLNode> map = new HashMap<>();
        int capacity;
        DLNode head, tail;
        public LRUCache(int capacity) {
            this.capacity = capacity;
            head = new DLNode();
            tail = new DLNode();
            head.prev = tail;
            tail.next = head;
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            DLNode node = map.get(key);
            if (node == null) {
                return -1;
            }
            this.moveToHead(node);
            return node.val;
        }

        public void put(int key, int value) {
            DLNode node = map.get(key);
            if (node == null) {
                node = new DLNode();
                node.key = key;
                node.val = value;
                addNode(node);
                map.put(key, node);
                if (map.size() > capacity) {
                    DLNode toRemove = popTail();
                    map.remove(toRemove.key);
                }
            } else {
                node.val = value;
                moveToHead(node);
            }
        }

        private void moveToHead(DLNode node) {
            removeNode(node);
            addNode(node);
        }

        private void removeNode(DLNode node) {
            DLNode prev = node.prev;
            DLNode next = node.next;
            prev.next = next;
            next.prev = prev;
        }

        private void addNode(DLNode node) {
            node.prev = head;
            node.next = head.next;
            head.next = node;
            node.next.prev = node;
        }

        private DLNode popTail() {
            DLNode toRemove = tail.prev;
            removeNode(toRemove);
            return toRemove;
        }
    }

    class DLNode {
        int key;
        int val;
        DLNode prev;
        DLNode next;
    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

}
