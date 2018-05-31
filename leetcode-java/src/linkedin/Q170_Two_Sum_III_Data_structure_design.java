package linkedin;

import java.util.*;

public class Q170_Two_Sum_III_Data_structure_design {

    class TwoSum {

        Set<Integer> sums = new HashSet<>();
        Set<Integer> nums = new HashSet<>();

        /** Initialize your data structure here. */
        public TwoSum() {

        }

        /** Add the number to an internal data structure.. */
        public void add(int number) {
            if (nums.contains(number)) {
                sums.add(number+number);
                return;
            }
            for (int num : nums) {
                sums.add(num+number);
            }
            nums.add(number);
        }

        /** Find if there exists any pair of numbers which sum is equal to the value. */
        public boolean find(int value) {
            return sums.contains(value);
        }
    }

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */

}
