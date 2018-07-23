package facebook;

import java.util.*;

public class Q296_Best_Meeting_Point {

    public int minTotalDistance(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length, n = grid[0].length;
        List<int[]> people = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    people.add(new int[]{i, j});
                }
            }
        }
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int dist = 0;
                for (int[] xy : people) {
                    int x = xy[0], y = xy[1];
                    dist += Math.abs(x-i)+Math.abs(y-j);
                }
                result = Math.min(result, dist);
            }
        }
        return result;
    }

}
