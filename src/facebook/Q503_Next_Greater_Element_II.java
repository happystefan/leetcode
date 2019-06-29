package facebook;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Q503_Next_Greater_Element_II {

    public int[] nextGreaterElements(int[] nums) {
        int[] nums_ext = new int[nums.length * 2];
        for (int i = 0; i < nums.length; i++) {
            nums_ext[i] = nums_ext[i + nums.length] = nums[i];
        }
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums_ext.length; i++) {
            while (!stack.isEmpty() && nums_ext[i] > nums_ext[stack.peek()]) {
                if (stack.peek() >= nums_ext.length) {
                    break;
                }
                map.put(stack.peek(), nums_ext[i]);
                stack.pop();
            }
            stack.push(i);
        }
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = map.getOrDefault(i, -1);
        }
        return result;
    }

}
