package Y2020.facebook.misc.monotonic_stack_queue;

import java.util.Stack;

public class Q0084_Largest_Rectangle_in_Histogram {

    class solution_lookup_table {

        public int largestRectangleArea(int[] heights) {
            if (heights == null || heights.length == 0) return 0;
            int n = heights.length;
            int[] ll = new int[n], rr = new int[n];
            ll[0] = -1;
            rr[n - 1] = n;
            for (int i = 1; i < n; i++) {
                int p = i - 1;
                while (p >= 0 && heights[p] >= heights[i]) p = ll[p];
                ll[i] = p;
            }
            for (int i = n - 1; i >= 0; i--) {
                int p = i + 1;
                while (p < n && heights[p] >= heights[i]) p = rr[p];
                rr[i] = p;
            }
            int rslt = 0;
            for (int i = 0; i < n; i++) {
                rslt = Math.max(rslt, heights[i] * (rr[i] - ll[i] - 1));
            }
            return rslt;
        }

    }

    class solution_two_stack {

        public int largestRectangleArea(int[] heights) {
            if (heights == null || heights.length == 0) return 0;
            int n = heights.length;
            int[] ll = new int[n], rr = new int[n];
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < heights.length; i++) {
                while (!stack.isEmpty() && heights[stack.peek()] >=heights[i]) stack.pop();
                ll[i] = stack.isEmpty() ? -1 : stack.peek();
                stack.push(i);
            }
            stack.clear();
            for (int i = n - 1; i >= 0; i--) {
                while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) stack.pop();
                rr[i] = stack.isEmpty() ? n : stack.peek();
                stack.push(i);
            }
            int rslt = 0;
            for (int i = 0; i < n; i++) {
                rslt = Math.max(rslt, heights[i] * (rr[i] - ll[i] - 1));
            }
            return rslt;
        }

    }

}
