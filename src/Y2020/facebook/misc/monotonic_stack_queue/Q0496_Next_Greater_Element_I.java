package Y2020.facebook.misc.monotonic_stack_queue;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Q0496_Next_Greater_Element_I {


    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && nums2[stack.peek()] < nums2[i]) {
                int j = stack.pop();
                map.put(nums2[j], nums2[i]);
            }
            stack.push(i);
        }
        int[] rslt = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            rslt[i] = map.containsKey(nums1[i]) ? map.get(nums1[i]) : -1;
        }
        return rslt;
    }

}
