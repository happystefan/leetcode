package Y2019.Q0001_Q0300;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Q0137_Single_Number_II {

    /*
     *------------------------------------------------------------------------------------------------------------------
     *
     * solution 1
     *
     *------------------------------------------------------------------------------------------------------------------
     */
    class solution1 {

        public int singleNumber(int[] nums) {
            Set<Integer> seen_once = new HashSet<>();
            Set<Integer> seen_twice = new HashSet<>();
            for (int num : nums) {
                if (!seen_once.contains(num) && !seen_twice.contains(num)) seen_once.add(num);
                else if (seen_once.contains(num) && !seen_twice.contains(num)) {
                    seen_once.remove(num);
                    seen_twice.add(num);
                }
            }
            return new ArrayList<>(seen_once).get(0);
        }

    }

    /*
     *------------------------------------------------------------------------------------------------------------------
     *
     * solution 2
     *
     *------------------------------------------------------------------------------------------------------------------
     */
    class solution2 {

        public int singleNumber(int[] nums) {
            int seen_once = 0;
            int seen_twice = 0;
            for (int num : nums) {
                // first appearance:
                // add num to seen_once
                // don't add to seen_twice because of presence in seen_once

                // second appearance:
                // remove num from seen_once
                // add num to seen_twice

                // third appearance:
                // don't add to seen_once because of presence in seen_twice
                // remove num from seen_twice
                seen_once = ~seen_twice & (seen_once ^ num);
                seen_twice = ~seen_once & (seen_twice ^ num);
            }
            return seen_once;
        }

    }

    /*
     *------------------------------------------------------------------------------------------------------------------
     *
     * solution 3
     *
     *------------------------------------------------------------------------------------------------------------------
     */
    class solution3 {

        public int singleNumber(int[] nums) {
            int one = 0;
            int two = 0;
            for (int num : nums) {
                one ^= num;
                int cry = ~one & num;
                two ^= cry;
                int msk = one & two;
                one ^= msk;
                two ^= msk;
            }
            return one;
        }

    }

}
