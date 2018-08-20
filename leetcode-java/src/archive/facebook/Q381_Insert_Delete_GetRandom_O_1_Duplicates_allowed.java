package archive.facebook;

import java.util.*;

public class Q381_Insert_Delete_GetRandom_O_1_Duplicates_allowed {


    class RandomizedCollection {

        Map<Integer, Set<Integer>> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        Random random = new Random();
        /** Initialize your data structure here. */
        public RandomizedCollection() {
        }

        /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
        public boolean insert(int val) {
            boolean cotains = map.containsKey(val);
            map.computeIfAbsent(val, k->new LinkedHashSet<>());
            map.get(val).add(list.size());
            list.add(val);
            return !cotains;
        }

        /** Removes a value from the collection. Returns true if the collection contained the specified element. */
        public boolean remove(int val) {
            if (!map.containsKey(val)) {
                return false;
            }
            int idx = map.get(val).iterator().next();
            map.get(val).remove(idx);
            if (idx < list.size()-1) {
                int last = list.get(list.size()-1);
                list.set(idx, last);
                map.get(last).remove(list.size()-1);
                map.get(last).add(idx);
            }
            //map.get(val).remove(idx);
            if (map.get(val).isEmpty()) {
                map.remove(val);
            }
            list.remove(list.size()-1);
            return true;
        }

        /** Get a random element from the collection. */
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
