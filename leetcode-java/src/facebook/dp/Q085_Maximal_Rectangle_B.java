package facebook.dp;

public class Q085_Maximal_Rectangle_B {

    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int result = 0;
        int[] heights = new int[m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                heights[j] = matrix[i][j] == '0'? 0 : heights[j]+1;
            }
            result = Math.max(result, maxArea(heights));
        }
        return result;
    }

    private int maxArea(int[] heights) {
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
            while (p <n && heights[p] >= heights[i]) {
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
