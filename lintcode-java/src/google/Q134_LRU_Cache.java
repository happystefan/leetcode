package google;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

public class Q134_LRU_Cache {

    public class LRUCache {

        Map<Integer, Integer> map = new HashMap<>();
        ArrayDeque<Integer> list = new ArrayDeque<>();
        int capacity;

        /*
         * @param capacity: An integer
         */public LRUCache(int capacity) {
            // do intialization if necessary
            this.capacity = capacity;
        }

        /*
         * @param key: An integer
         * @return: An integer
         */
        public int get(int key) {
            // write your code here
            if (map.containsKey(key)) {
                list.removeFirstOccurrence(key);
                list.addFirst(key);
                return map.get(key);
            }
            return -1;
        }

        /*
         * @param key: An integer
         * @param value: An integer
         * @return: nothing
         */
        public void set(int key, int value) {
            // write your code here
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
