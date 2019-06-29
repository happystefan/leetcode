package Y2018.facebook.design;

import java.util.HashMap;
import java.util.Map;

public class Q146_LRU_Cache {

    class LRUCache {

        Map<Integer, ListNode> map = new HashMap<>();
        ListNode head = new ListNode(-1, -1);
        ListNode tail = new ListNode(-1, -1);
        int cap;

        public LRUCache(int capacity) {
            head.next = tail;
            tail.prev = head;
            this.cap = capacity;
        }

        private void delete(ListNode node) {
            ListNode prev = node.prev;
            ListNode next = node.next;
            prev.next = next;
            next.prev = prev;
        }

        private void insert(ListNode node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
        }

        public int get(int key) {
            if (!map.containsKey(key)) return -1;
            ListNode node = map.get(key);
            delete(node);
            insert(node);
            return node.val;
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                map.get(key).val = value;
                get(key);
                return;
            }
            ListNode node = new ListNode(key, value);
            map.put(key, node);
            insert(node);
            if (map.size() > cap) {
                map.remove(tail.prev.key);
                delete(tail.prev);
            }
        }

    }

    class ListNode {
        int key;
        int val;
        ListNode prev;
        ListNode next;

        public ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

}


