package google;


import java.util.*;

/**
 * Created by mingqiangliang on 12/23/17.
 */
public class Q657_Insert_Delete_GetRandom_O1 {

    public class RandomizedSet {

        List<Integer> list = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();
        Random rand = new Random();

        public RandomizedSet() {
            // do intialization if necessary
        }

        /*
         * @param val: a value to the set
         * @return: true if the set did not already contain the specified element or false
         */
        public boolean insert(int val) {
            // write your code here
            if (map.containsKey(val)) {
                return false;
            }
            map.put(val, list.size());
            list.add(val);
            return true;
        }

        /*
         * @param val: a value from the set
         * @return: true if the set contained the specified element or false
         */
        public boolean remove(int val) {
            // write your code here
            if (!map.containsKey(val)) return false;
            if (map.get(val) < list.size()-1) {
                map.put(val, map.get(list.size()-1));
            }
            list.remove(list.size()-1);
            map.remove(val);
            return true;
        }

        /*
         * @return: Get a random element from the set
         */
        public int getRandom() {
            // write your code here
            return list.get(rand.nextInt(list.size()));
        }
    }

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param = obj.insert(val);
 * boolean param = obj.remove(val);
 * int param = obj.getRandom();
 */

}
