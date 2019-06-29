package Y2018.Q001_Q300;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

public class Q146_LRU_Cache {

    class LRUCache {

        public Map<Integer, Integer> cache;
        public ArrayDeque<Integer> list;
        private int capacity;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            cache = new HashMap<>();
            list = new ArrayDeque<>();
        }

        public int get(int key) {
            if (cache.containsKey(key)) {
                list.removeFirstOccurrence(key);
                list.addFirst(key);
                return cache.get(key);
            }
            return -1;
        }

        public void put(int key, int value) {
            list.removeFirstOccurrence(key);
            list.addFirst(key);
            cache.put(key, value);
            if (cache.size() > capacity) {
                cache.remove(list.getLast());
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

