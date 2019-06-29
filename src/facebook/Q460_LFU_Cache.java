package facebook;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class Q460_LFU_Cache {

    class LFUCache {
        Map<Integer, Integer> cache = new HashMap<>();
        Map<Integer, Integer> count = new HashMap<>();
        Map<Integer, LinkedHashSet<Integer>> index = new HashMap<>();
        int cap;
        int min;

        public LFUCache(int capacity) {
            cap = capacity;
            min = -1;
        }

        public int get(int key) {
            if (!cache.containsKey(key)) {
                return -1;
            }
            int cnt = count.get(key);
            count.put(key, cnt + 1);
            index.get(cnt).remove(key);
            index.computeIfAbsent(cnt + 1, k -> new LinkedHashSet<>());
            index.get(cnt + 1).add(key);
            if (cnt == min && index.get(min).size() == 0) {
                min++;
            }
            return cache.get(key);
        }

        public void put(int key, int value) {
            if (cap <= 0) {
                return;
            }
            if (cache.containsKey(key)) {
                cache.put(key, value);
                get(key);
                return;
            }
            if (cache.size() >= cap) {
                int evict = index.get(min).iterator().next();
                index.get(min).remove(evict);
                cache.remove(evict);
            }
            cache.put(key, value);
            count.put(key, 1);
            min = 1;
            index.computeIfAbsent(1, k -> new LinkedHashSet<>());
            index.get(1).add(key);
        }
    }

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

}