package Y2020.linkedin.algo_part1;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Q029_Shuffle_An_Array {

    /*
    Proof: each element has a probability of 1/n on every position
    1st position: 1/n   select one out of n elements
    2nd position: (n-1)/n * 1/(n-1) select one out of n-1 elements (those n-1
                  elements are not get selected in the first round)
    3rd position: (n-1)/n * (n-2)/(n-1) * 1/(n-2) = 1/n
    ...
    nth position: (n-1)/n * (n-2)/(n-1) * (n-3)/(n-2) * 2/3 * 1/2 * 1/1 = 1/n
    * */
    class solution_imp {
        public void shuffle(int[] nums) {
            if (nums == null || nums.length == 0) return;
            Random rand = new Random();
            for (int i = 0; i < nums.length; i++) {
                swap(nums, i, i + rand.nextInt(nums.length - i));
            }
        }

        private void swap(int[] nums, int i, int j) {
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
        }
    }

    class solution_api {
        public void shuffle(int[] nums) {
            if (nums == null || nums.length == 0) return;
            // Arrays.asList() returns a fixed-size list backed by the specified array.
            // (Changes to the returned list "write through" to the array.)
            Collections.shuffle(Arrays.asList(nums));
        }
    }

}
