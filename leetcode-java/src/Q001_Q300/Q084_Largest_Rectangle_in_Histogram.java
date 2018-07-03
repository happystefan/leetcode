package Q001_Q300;

import java.util.Stack;

public class Q084_Largest_Rectangle_in_Histogram {

    public int largestRectangleArea(int[] heights) {
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            while(!stack.isEmpty() && heights[i] < heights[stack.peek()]){
                int pos = stack.pop();
                int w = stack.isEmpty()? i : i - stack.peek() - 1;
                int h = heights[pos];
                result = Math.max(result, w * h);
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            int pos = stack.pop();
            int w = stack.isEmpty()? heights.length : heights.length - stack.peek() - 1;
            int h = heights[pos];
            result = Math.max(result, w * h);
        }
        return result;
    }

}
