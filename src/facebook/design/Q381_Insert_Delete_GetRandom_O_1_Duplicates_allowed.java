package facebook.design;

import java.util.*;

public class Q381_Insert_Delete_GetRandom_O_1_Duplicates_allowed {

    class RandomizedCollection {

        Map<Integer, Set<Integer>> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        Random random = new Random();

        /**
         * Initialize your data structure here.
         */
        public RandomizedCollection() {

        }

        /**
         * Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
         */
        public boolean insert(int val) {
            boolean result = !map.containsKey(val);
            map.computeIfAbsent(val, k -> new HashSet<>());
            map.get(val).add(list.size());
            list.add(val);
            return result;
        }

        /**
         * Removes a value from the collection. Returns true if the collection contained the specified element.
         */
        public boolean remove(int val) {
            if (!map.containsKey(val) || map.get(val).isEmpty()) {
                return false;
            }
            int idx = map.get(val).iterator().next();
            map.get(val).remove(idx);
            int lastIdx = list.size() - 1;
            if (idx != lastIdx) {
                int lastVal = list.get(lastIdx);
                map.get(lastVal).remove(lastIdx);
                map.get(lastVal).add(idx);
                list.set(idx, lastVal);
            }
            list.remove(lastIdx);
            return true;
        }

        /**
         * Get a random element from the collection.
         */
        public int getRandom() {
            return list.get(random.nextInt(list.size()));
        }
    }

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */

}
