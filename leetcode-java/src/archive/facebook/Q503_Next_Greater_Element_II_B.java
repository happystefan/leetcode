package archive.facebook;

import java.util.*;

public class Q503_Next_Greater_Element_II_B {

    public int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];
        Arrays.fill(result, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length*2; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i%nums.length]) {
                result[stack.peek()] = nums[i%nums.length];
                stack.pop();
            }
            if (i < nums.length) {
                stack.push(i);
            }
        }
        return result;
    }

}
