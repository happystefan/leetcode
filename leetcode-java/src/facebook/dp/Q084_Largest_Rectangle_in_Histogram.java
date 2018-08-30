package facebook.dp;

public class Q084_Largest_Rectangle_in_Histogram {

    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        int n = heights.length;
        int[] lessFromLeft = new int[n];
        int[] lessFromRight= new int[n];
        lessFromLeft[0] = -1;
        lessFromRight[n-1] = n;
        for (int i = 1; i < n; i++) {
            int p = i-1;
            while (p >= 0 && heights[p] >= heights[i]) {
                p = lessFromLeft[p];
            }
            lessFromLeft[i] = p;
        }
        for (int i = n-2; i >= 0; i--) {
            int p = i+1;
            while (p < n && heights[p] >= heights[i]) {
                p = lessFromRight[p];
            }
            lessFromRight[i] = p;
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            result = Math.max(result, heights[i]*(lessFromRight[i]-lessFromLeft[i]-1));
        }
        return result;
    }

}
