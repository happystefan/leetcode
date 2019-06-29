package Y2018.facebook;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Q305_Number_of_Islands_II {

    int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        int cnt = 0;
        int[] p = new int[m * n];
        Arrays.fill(p, -1);
        List<Integer> result = new LinkedList<>();
        for (int[] position : positions) {
            int i = position[0], j = position[1];
            p[i * n + j] = i * n + j;
            cnt++;
            int cp = findp(i * n + j, p);
            for (int[] dir : dirs) {
                int ii = i + dir[0], jj = j + dir[1];
                if (ii < 0 || ii >= m || jj < 0 || jj >= n || p[ii * n + jj] == -1) {
                    continue;
                }
                int np = findp(ii * n + jj, p);
                if (cp != np) {
                    p[cp] = np;
                    cp = np;
                    cnt--;
                }
            }
            result.add(cnt);
        }
        return result;
    }

    private int findp(int i, int[] p) {
        if (i != p[i]) {
            p[i] = findp(p[i], p);
        }
        return p[i];
    }

}
