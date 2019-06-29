package Y2018.facebook;

import java.util.ArrayList;
import java.util.List;

public class Q296_Best_Meeting_Point_B {

    public int minTotalDistance(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length, n = grid[0].length;
        ArrayList<Integer> I = new ArrayList<>(m);
        ArrayList<Integer> J = new ArrayList<>(n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    I.add(i);
                    J.add(j);
                }
            }
        }
        return dist(I) + dist(J);
    }

    private int dist(List<Integer> list) {
        int i = 0, j = list.size() - 1;
        int result = 0;
        while (i < j) {
            result += list.get(j) - list.get(i);
            i++;
            j--;
        }
        return result;
    }

}
