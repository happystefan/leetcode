package Y2019.Q0001_Q0300;

import java.util.Stack;

public class Q0084_Largest_Rectangle_in_Histogram {

    /*
     *------------------------------------------------------------------------------------------------------------------
     *
     * solution 1: divide and conquer
     *
     *------------------------------------------------------------------------------------------------------------------
     */
    public int largestRectangleArea_DC(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        return largest(heights, 0, heights.length - 1);
    }

    private int largest(int[] heights, int l, int r) {
        if (l > r) return 0;
        if (l == r) return Math.min(heights[l], heights[r]);
        int m = l + (r - l) / 2;
        int i = m, j = m + 1;
        int h = Integer.MAX_VALUE;
        int area = Integer.MIN_VALUE;
        while (i >= l && j <= r) {
            h = Math.min(h, Math.min(heights[i], heights[j]));
            area = Math.max(area, h * (j - i + 1));
            if (i == l) j++;
            else if (j == r) i--;
            else if (heights[i - 1] < heights[j + 1]) j++;
            else i--;
        }
        return Math.max(Math.max(largest(heights, l, m), largest(heights, m + 1, r)), area);
    }

    /*
     *------------------------------------------------------------------------------------------------------------------
     *
     * solution 2: build search index of next smaller element
     *
     *------------------------------------------------------------------------------------------------------------------
     */
    public int largestRectangleArea_index(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        int n = heights.length;
        int[] ll = new int[n];
        int[] rr = new int[n];
        ll[0] = -1;
        rr[n - 1] = n;
        for (int i = 1; i < n; i++) {
            int p = i - 1;
            while (p >= 0 && heights[p] >= heights[i]) p = ll[p];
            ll[i] = p;
        }
        for (int i = n - 2; i >= 0; i--) {
            int p = i + 1;
            while (p < n && heights[p] >= heights[i]) p = rr[p];
            rr[i] = p;
        }
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            result = Math.max(result, heights[i] * (rr[i] - ll[i] - 1));
        }
        return result;
    }

    /*
     *------------------------------------------------------------------------------------------------------------------
     *
     * solution 3: monotonous stack
     *
     *------------------------------------------------------------------------------------------------------------------
     */
    public int largestRectangleArea_stack(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        for (int i = 0; i <= heights.length; i++) {
            while (!stack.isEmpty() && (i == heights.length || heights[i] <= heights[stack.peek()])) {
                int h = heights[stack.pop()];
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                result = Math.max(result, w * h);
            }
            stack.add(i);
        }
        return result;
    }

    /*
     *------------------------------------------------------------------------------------------------------------------
     *
     * solution 4: brute force with prune
     *
     *------------------------------------------------------------------------------------------------------------------
     */
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < heights.length; i++) {
            int h = heights[i];
            for (int j = i; j < heights.length; j++) {
                h = Math.min(h, heights[j]);
                result = Math.max(result, h * (j - i + 1));
            }
        }
        return result;
    }

}
