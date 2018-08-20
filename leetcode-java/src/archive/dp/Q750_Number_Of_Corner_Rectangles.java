package archive.dp;

public class Q750_Number_Of_Corner_Rectangles {

    public int countCornerRectangles(int[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                for (int m = i+1; m < grid.length; m++) {
                    for (int n = j+1; n < grid[0].length; n++) {
                        if (grid[m][n] == 0) {
                            continue;
                        }
                        int ci = i, cj = n;
                        int di = m, dj = j;
                        if (grid[ci][cj] == 1 && grid[di][dj] == 1) {
                            result++;
                        }
                    }
                }
            }
        }
        return result;
    }

}
