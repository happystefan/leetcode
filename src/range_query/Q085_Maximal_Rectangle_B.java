package range_query;

import java.util.Stack;

public class Q085_Maximal_Rectangle_B {

    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length, n = matrix[0].length;
        int[][] heights = new int[m][n];
        for (int j = 0; j < n; j++) {
            heights[0][j] = matrix[0][j] == '1' ? 1 : 0;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                heights[i][j] = matrix[i][j] == '1' ? heights[i - 1][j] + 1 : 0;
            }
        }
        int result = 0;
        for (int[] height : heights) {
            Stack<Integer> stack = new Stack<>();
            stack.push(-1);
            for (int i = 0; i < height.length; i++) {
                while (stack.peek() != -1 && height[i] <= height[stack.peek()]) {
                    result = Math.max(result, height[stack.pop()] * (i - stack.peek() - 1));
                }
                stack.push(i);
            }
            while (stack.peek() != -1) {
                result = Math.max(result, height[stack.pop()] * (height.length - stack.peek() - 1));
            }
        }
        return result;
    }

}
