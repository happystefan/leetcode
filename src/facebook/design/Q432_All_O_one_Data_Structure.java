package facebook.design;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Q432_All_O_one_Data_Structure {

    class AllOne {

        Map<Integer, ListNode> index = new HashMap<>();
        Map<String, Integer> map = new HashMap<>();
        // head and tail are actually dummy nodes.
        ListNode head = new ListNode();
        ListNode tail = new ListNode();

        /**
         * Initialize your data structure here.
         */
        public AllOne() {
            head.next = tail;
            tail.next = head;
        }

        private void insert(ListNode prev, ListNode node) {
            ListNode next = prev.next;

            prev.next = node;
            node.prev = prev;
            node.next = next;
            next.prev = node;
        }

        private void delete(ListNode node) {
            if (node == null) return;
            ListNode prev = node.prev;
            ListNode next = node.next;
            prev.next = next;
            next.prev = prev;
        }

        /**
         * Inserts a new key <Key> with value 1. Or increments an existing key by 1.
         */
        public void inc(String key) {
            int oldCnt = map.getOrDefault(key, 0);
            int newCnt = oldCnt + 1;
            map.put(key, newCnt);

            ListNode oldNode = index.get(oldCnt);
            ListNode newNode = index.getOrDefault(newCnt, new ListNode());
            newNode.set.add(key);

            if (!index.containsKey(newCnt)) {
                index.put(newCnt, newNode);
                insert(oldNode == null ? head : oldNode, newNode);
            }
            if (oldNode != null) {
                oldNode.set.remove(key);
                if (oldNode.set.isEmpty()) {
                    delete(oldNode);
                    index.remove(oldCnt);
                }
            }
        }

        /**
         * Decrements an existing key by 1. If Key's value is 1, remove it from the data structure.
         */
        public void dec(String key) {
            if (!map.containsKey(key)) return;

            int oldCnt = map.get(key);
            int newCnt = oldCnt - 1;
            map.put(key, newCnt);
            if (newCnt == 0) map.remove(key);

            ListNode oldNode = index.get(oldCnt);
            ListNode newNode = index.getOrDefault(newCnt, new ListNode());
            newNode.set.add(key);

            if (newCnt != 0 && !index.containsKey(newCnt)) {
                index.put(newCnt, newNode);
                insert(oldNode == null ? head : oldNode, newNode);
            }

            oldNode.set.remove(key);
            if (oldNode.set.isEmpty()) {
                index.remove(oldCnt);
                delete(oldNode);
            }
        }

        /**
         * Returns one of the keys with maximal value.
         */
        public String getMaxKey() {
            if (head.next == tail) return "";
            return tail.prev.set.iterator().next();
        }

        /**
         * Returns one of the keys with Minimal value.
         */
        public String getMinKey() {
            if (head.next == tail) return "";
            return head.next.set.iterator().next();
        }
    }

    class ListNode {
        ListNode prev;
        ListNode next;
        Set<String> set = new HashSet<>();
    }

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */

}
