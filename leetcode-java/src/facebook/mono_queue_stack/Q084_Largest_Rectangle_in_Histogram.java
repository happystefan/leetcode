package facebook.mono_queue_stack;

import java.util.Stack;

public class Q084_Largest_Rectangle_in_Histogram {

    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        for (int i = 0; i <= heights.length; i++) {
            while (!stack.isEmpty() && (i == heights.length || heights[i] < heights[stack.peek()])) {
                int h = heights[stack.pop()];
                int w = stack.isEmpty()? i : i - stack.peek() - 1;
                result = Math.max(result, w * h);
            }
            stack.push(i);
        }
        return result;
    }


}
