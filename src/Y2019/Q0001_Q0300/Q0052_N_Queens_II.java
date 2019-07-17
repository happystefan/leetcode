package Y2019.Q0001_Q0300;

import java.util.HashSet;
import java.util.Set;

public class Q0052_N_Queens_II {

    Set<Integer> rows = new HashSet<>();
    Set<Integer> cols = new HashSet<>();
    Set<Integer> dia1 = new HashSet<>();
    Set<Integer> dia2 = new HashSet<>();

    public int totalNQueens(int n) {
        int[] result = new int[]{0};
        dfs(result, 0, n);
        return result[0];
    }

    private void dfs(int[] result, int i, int n) {
        if (i == n) {
            result[0]++;
            return;
        }
        for (int j = 0; j < n; j++) {
            if (rows.contains(i)) continue;
            if (cols.contains(j)) continue;
            if (dia1.contains(i + j)) continue;
            if (dia2.contains(i - j)) continue;
            rows.add(i);
            cols.add(j);
            dia1.add(i + j);
            dia2.add(i - j);
            dfs(result, i + 1, n);
            rows.remove(i);
            cols.remove(j);
            dia1.remove(i + j);
            dia2.remove(i - j);
        }
    }

}
