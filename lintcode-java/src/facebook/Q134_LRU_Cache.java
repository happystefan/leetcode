package facebook;

import java.util.*;

public class Q134_LRU_Cache {

    public class LRUCache {
        Map<Integer, Integer> map = new HashMap<>();
        LinkedList<Integer> list = new LinkedList<>();
        int capacity = 0;

        /*
         * @param capacity: An integer
         */
        public LRUCache(int capacity) {
            this.capacity = capacity;
        }

        /*
         * @param key: An integer
         * @return: An integer
         */
        public int get(int key) {
            if (map.containsKey(key)) {
                int value = map.get(key);
                list.removeFirstOccurrence(key);
                list.addFirst(key);
                return value;
            }
            return -1;
        }

        /*
         * @param key: An integer
         * @param value: An integer
         * @return: nothing
         */
        public void set(int key, int value) {
            list.removeFirstOccurrence(key);
            list.addFirst(key);
            map.put(key, value);
            if (map.size() > capacity) {
                map.remove(list.getLast());
                list.removeLast();
            }
        }
    }

}
