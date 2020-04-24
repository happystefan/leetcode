package Y2020.facebook.misc;

import java.util.*;

public class Q0381_Insert_Delete_GetRandom_O_1_Duplicates_allowed {

    class RandomizedCollection {

        Map<Integer, Set<Integer>> map = new HashMap<>();
        List<Integer> list = new LinkedList<>();
        Random r = new Random();

        /**
         * Initialize your data structure here.
         */
        public RandomizedCollection() {

        }

        /**
         * Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
         */
        public boolean insert(int val) {
            boolean rslt = !map.containsKey(val);
            map.computeIfAbsent(val, k -> new HashSet<>());
            map.get(val).add(list.size());
            list.add(val);
            return rslt;
        }

        /**
         * Removes a value from the collection. Returns true if the collection contained the specified element.
         */
        public boolean remove(int val) {
            if (!map.containsKey(val)) return false;
            int idx = map.get(val).iterator().next();
            map.get(val).remove(idx);

            int lastIdx = list.size() - 1;
            if (idx != lastIdx) {
                int lastValue = list.get(lastIdx);
                map.get(lastValue).remove(lastIdx);
                map.get(lastValue).add(idx);
                list.set(idx, lastValue);
            }

            if (map.get(val).size() == 0) map.remove(val);

            list.remove(lastIdx);
            return true;
        }

        /**
         * Get a random element from the collection.
         */
        public int getRandom() {
            int idx = r.nextInt(list.size());
            return list.get(idx);
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
