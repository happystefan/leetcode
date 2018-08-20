package archive.facebook;

import java.util.*;

public class Q398_Random_Pick_Index {

    class Solution {
        Map<Integer, List<Integer>> map = new HashMap<>();
        Random random = new Random();
        public Solution(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                map.computeIfAbsent(nums[i], k->new LinkedList<>());
                map.get(nums[i]).add(i);
            }
        }

        public int pick(int target) {
            return map.get(target).get(random.nextInt(map.get(target).size()));
        }
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */

}
