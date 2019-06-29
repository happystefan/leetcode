package facebook;

import java.util.Random;

public class Q398_Random_Pick_Index_B {

    class Solution {

        int[] nums;
        Random random = new Random();

        public Solution(int[] nums) {
            this.nums = nums;
        }

        public int pick(int target) {
            int total = 0;
            for (int num : nums) {
                if (num == target) {
                    total++;
                }
            }
            int rand = random.nextInt(total);
            int cnt = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == target) {
                    if (cnt == rand) {
                        return i;
                    } else {
                        cnt++;
                    }
                }
            }
            return -1;
        }
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */

}
