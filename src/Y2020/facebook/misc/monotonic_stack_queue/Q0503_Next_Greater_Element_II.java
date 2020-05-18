package Y2020.facebook.misc.monotonic_stack_queue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Q0503_Next_Greater_Element_II {

    class solution_stack_map {

        public int[] nextGreaterElements(int[] nums) {
            if (nums == null || nums.length == 0) return new int[0];
            Map<Integer, Integer> map = new HashMap<>();
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < nums.length * 2 - 1; i++) {
                while (!stack.isEmpty() && nums[stack.peek() % nums.length] < nums[i % nums.length]) {
                    int j = stack.pop() % nums.length;
                    map.put(j, i % nums.length);
                }
                stack.add(i);
            }
            int[] rslt = new int[nums.length];
            Arrays.fill(rslt, -1);
            for (int i : map.keySet()) {
                rslt[i] = nums[map.get(i)];
            }
            return rslt;
        }

    }

    class solution_better_space {

        public int[] nextGreaterElements(int[] nums) {
            if (nums == null || nums.length == 0) return new int[0];


        }

    }

}
