package Y2018.range_query;

import java.util.Stack;

public class Q084_Largest_Rectangle_in_Histogram_B {

    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int result = 0;
        for (int i = 0; i < heights.length; ++i) {
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
                result = Math.max(result, heights[stack.pop()] * (i - stack.peek() - 1));
            }
            stack.push(i);
        }
        while (stack.peek() != -1) {
            result = Math.max(result, heights[stack.pop()] * (heights.length - stack.peek() - 1));
        }
        return result;
    }

}
