package archive.google;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

public class Q146_LRU_Cache {

    class LRUCache {

        Map<Integer, Integer> map = new HashMap<>();
        ArrayDeque<Integer> list = new ArrayDeque<>();
        int capacity;

        public LRUCache(int capacity) {
            this.capacity = capacity;
        }

        public int get(int key) {
            if (map.containsKey(key)) {
                list.removeFirstOccurrence(key);
                list.addFirst(key);
                return map.get(key);
            }
            return -1;
        }

        public void put(int key, int value) {
            list.removeFirstOccurrence(key);
            list.addFirst(key);
            map.put(key, value);
            if (map.size() > capacity) {
                map.remove(list.getLast());
                list.removeLast();
            }
        }
    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

}
