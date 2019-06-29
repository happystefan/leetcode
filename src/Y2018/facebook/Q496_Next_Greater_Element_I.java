package Y2018.facebook;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Q496_Next_Greater_Element_I {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int num : nums2) {
            while (!stack.isEmpty() && stack.peek() < num) {
                map.put(stack.peek(), num);
                stack.pop();
            }
            stack.push(num);
        }
        int[] result = new int[nums1.length];
        int k = 0;
        for (int num : nums1) {
            result[k++] = map.getOrDefault(num, -1);
        }
        return result;
    }

}
