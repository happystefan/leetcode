package Y2018.facebook;

public class Q084_Largest_Rectangle_in_Histogram {

    public int largestRectangleArea(int[] heights) {
        return largestArea(heights, 0, heights.length - 1);
    }

    private int largestArea(int[] heights, int l, int r) {
        if (l > r) return 0;
        if (l == r) return heights[l];
        int m = l + (r - l) / 2;
        int i = m, j = m + 1;
        int h = Math.min(heights[i], heights[j]);
        int result = 0;
        while (i >= l && j <= r) {
            h = Math.min(h, Math.min(heights[i], heights[j]));
            result = Math.max(result, h * (j - i + 1));
            if (i == l) j++;
            else if (j == r) i--;
            else if (heights[i - 1] > heights[j + 1]) i--;
            else j++;
        }
        return Math.max(result, Math.max(largestArea(heights, l, m), largestArea(heights, m + 1, r)));
    }

}
