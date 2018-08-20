package archive.google;

import java.util.*;

public class Q460_LFU_Cache {

    class LFUCache {

        Map<Integer, Integer> cache = new HashMap<>();
        Map<Integer, Integer> count = new HashMap<>();
        Map<Integer, LinkedHashSet<Integer>> index = new HashMap<>();

        int cap;
        int min;

        public LFUCache(int capacity) {
            this.cap = capacity;
            this.min = -1;
        }

        public int get(int key) {
            if (!cache.containsKey(key)) return -1;

            int cnt = count.get(key);
            count.put(key, cnt+1);

            index.get(cnt).remove(key);
            if(cnt==min && index.get(cnt).size()==0) min++;

            if (!index.containsKey(cnt+1)) index.put(cnt+1, new LinkedHashSet<>());
            index.get(cnt+1).add(key);

            return cache.get(key);
        }

        public void put(int key, int value) {
            if (cap <= 0) return;
            if (cache.containsKey(key)) {
                cache.put(key, value);
                get(key);
            }
            if (cache.size() >= cap) {
                int evit = index.get(min).iterator().next();
                index.get(min).remove(evit);
                cache.remove(evit);
            }
            cache.put(key, value);
            count.put(key, 1);
            min = 1;
            if (!index.containsKey(1)) index.put(1, new LinkedHashSet<>());
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
