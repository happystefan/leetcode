package Y2019.monotonic_stack_queue;

import java.util.Stack;

public class Q0084_Largest_Rectangle_in_Histogram {

    /*
     *------------------------------------------------------------------------------------------------------------------
     *
     * solution 1: divide and conquer -- N*log(N)
     *
     *------------------------------------------------------------------------------------------------------------------
     */
    class solution1 {

        public int largestRectangleArea(int[] heights) {
            if (heights == null || heights.length == 0) return 0;
            return largest(heights, 0, heights.length - 1);
        }

        private int largest(int[] height, int l, int r) {
            if (l > r) return 0;
            if (l == r) return height[l];
            int m = l + (r - l) / 2;
            int area = Integer.MIN_VALUE;
            int i = m, j = m + 1;
            int h = Math.min(height[i], height[j]);
            while (i >= l && j <= r) {
                h = Math.min(h, Math.min(height[i], height[j]));
                area = Math.max(area, h * (j - i + 1));
                if (i == l) j++;
                else if (j == r) i--;
                else if (height[i - 1] > height[j + 1]) i--;
                else j++;
            }
            return Math.max(area, Math.max(largest(height, l, m), largest(height, m + 1, r)));
        }

    }

    /*
     *------------------------------------------------------------------------------------------------------------------
     *
     * solution 2: lookup table with path compression -- 3*N
     *
     *------------------------------------------------------------------------------------------------------------------
     */
    class solution2 {

        public int largestRectangleArea(int[] heights) {
            if (heights == null || heights.length == 0) return 0;
            int n = heights.length;
            int[] l = new int[n];
            int[] r = new int[n];
            l[0] = -1;
            r[n - 1] = n;
            for (int i = 1; i < n; i++) {
                int p = i - 1;
                while (p >= 0 && heights[p] >= heights[i]) p = l[p];
                l[i] = p;
            }
            for (int i = n - 1; i >= 0; i--) {
                int p = i + 1;
                while (p < n && heights[p] >= heights[i]) p = r[p];
                r[i] = p;
            }
            int result = 0;
            for (int i = 0; i < n; i++) {
                result = Math.max(result, heights[i] * (r[i] - l[i] - 1));
            }
            return result;
        }

    }

    /*
     *------------------------------------------------------------------------------------------------------------------
     *
     * solution 3: monotonic stack
     *
     *------------------------------------------------------------------------------------------------------------------
     */
    class solution3_v1 {

        public int largestRectangleArea(int[] heights) {
            if (heights == null || heights.length == 0) return 0;
            Stack<Integer> stack = new Stack<>();
            int result = 0;
            for (int i = 0; i <= heights.length; i++) {
                while (!stack.isEmpty() && (i == heights.length || heights[stack.peek()] > heights[i])) {
                    int h = heights[stack.pop()];
                    int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                    result = Math.max(result, h * w);
                }
                stack.add(i);
            }
            return result;
        }

    }

    class solution3_v2 {

        public int largestRectangleArea(int[] heights) {
            if (heights == null || heights.length == 0) return 0;
            int[] hh = new int[heights.length + 1];
            System.arraycopy(heights, 0, hh, 0, heights.length);
            hh[heights.length] = 0;
            Stack<Integer> stack = new Stack<>();
            int result = 0;
            for (int i = 0; i < hh.length; i++) {
                while (!stack.isEmpty() && hh[stack.peek()] > hh[i]) {
                    int h = hh[stack.pop()];
                    int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                    result = Math.max(result, h * w);
                }
                stack.add(i);
            }
            return result;
        }

    }

}
