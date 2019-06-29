package Y2018.linkedin;

import java.util.HashMap;

public class Q170_Two_Sum_III_Data_structure_design_B {

    class TwoSum {

        HashMap<Integer, Integer> map = new HashMap<>();

        /**
         * Initialize your data structure here.
         */
        public TwoSum() {

        }

        /**
         * Add the number to an internal data structure..
         */
        public void add(int number) {
            map.put(number, map.getOrDefault(number, 0) + 1);
        }

        /**
         * Find if there exists any pair of numbers which sum is equal to the value.
         */
        public boolean find(int value) {
            for (int num : map.keySet()) {
                if (value - num == num && map.get(num) > 1) {
                    return true;
                }
                if (value - num != num && map.containsKey(value - num)) {
                    return true;
                }
            }
            return false;
        }
    }

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */

}