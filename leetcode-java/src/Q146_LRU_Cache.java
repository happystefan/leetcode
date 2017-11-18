import java.util.*;

public class Q146_LRU_Cache {
    public static void main(String[] args) {
        LRUCache lru = new LRUCache(2);
        lru.put(2, 6);
        lru.put(1, 5);
        System.out.println(lru.cache.entrySet());
        lru.put(1, 2);
        System.out.println(lru.cache.entrySet());
    }

}

class LRUCache {

    private int capacity;
    public Map<Integer, Integer> cache;
    public ArrayDeque<Integer> list;

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
