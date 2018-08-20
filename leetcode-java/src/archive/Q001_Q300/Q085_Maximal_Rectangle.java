package archive.Q001_Q300;

import java.util.Stack;

public class Q085_Maximal_Rectangle {

    public int maximalRectangle(char[][] matrix) {

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int n = matrix.length, m = matrix[0].length;
        int[][] heights = new int[n][m];

        for (int j = 0; j < m; j++) {
            heights[0][j] = matrix[0][j] == '0' ? 0 : 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                heights[i][j] = matrix[i][j] == '0' ? 0 : heights[i-1][j]+1;
            }
        }

        int result = 0;
        for(int[] height : heights) {
            int area = 0;
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < height.length; i++) {
                while (!stack.isEmpty() && height[i] < height[stack.peek()]) {
                    int pos = stack.pop();
                    int w = stack.isEmpty() ? i : i-stack.peek()-1;
                    int h = height[pos];
                    area = Math.max(area, w*h);
                }
                stack.push(i);
            }
            while (!stack.isEmpty()) {
                int pos = stack.pop();
                int w = stack.isEmpty() ? height.length : height.length-stack.peek()-1;
                int h = height[pos];
                area = Math.max(area, w*h);
            }
            result = Math.max(result, area);
        }

        return result;

    }

}
