package Y2019.Q0001_Q0300;

import java.util.ArrayList;
import java.util.Collections;

public class Q0296_Best_Meeting_Point {

    public int minTotalDistance(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) return 0;
        ArrayList<Integer> rows = new ArrayList<>();
        ArrayList<Integer> cols = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) continue;
                rows.add(i);
                cols.add(j);
            }
        }
        Collections.sort(cols);
        return dis(rows) + dis(cols);
    }

    private int dis(ArrayList<Integer> list) {
        int m = list.get(list.size() / 2);
        int result = 0;
        for (int num : list) result += Math.abs(m - num);
        return result;
    }

    private int dis_v2(ArrayList<Integer> list) {
        int result = 0;
        int i = 0, j = list.size() - 1;
        while (i < j) result += list.get(j--) - list.get(i++);
        return result;
    }

}
