package dp;

public class Q750_Number_Of_Corner_Rectangles_B {

    public int countCornerRectangles(int[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = i+1; j < grid.length; j++) {
                int cnt = 0;
                for (int k = 0; k < grid[0].length; k++) {
                    if (grid[i][k] == 1 && grid[j][k] == 1) {
                        cnt++;
                    }
                }
                result += cnt*(cnt-1)/2;
            }
        }
        return result;
    }

}
