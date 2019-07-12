package Y2019.Q0001_Q0300;

import java.util.*;

public class Q0051_N_Queens {

    Set<Integer> rows = new HashSet<>();
    Set<Integer> cols = new HashSet<>();
    Set<Integer> dia1 = new HashSet<>();
    Set<Integer> dia2 = new HashSet<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        List<List<String>> result = new LinkedList<>();
        dfs(result, board, 0, n);
        return result;
    }

    private void dfs(List<List<String>> result, char[][] board, int i, int n) {
        if (i == n) {
            List<String> list = new LinkedList<>();
            for (char[] row : board) {
                list.add(new String(row));
            }
            result.add(list);
            return;
        }
        for (int j = 0; j < n; j++) {
            if (rows.contains(i)) continue;
            if (cols.contains(j)) continue;
            if (dia1.contains(i - j)) continue;
            if (dia2.contains(i + j)) continue;
            rows.add(i);
            cols.add(j);
            dia1.add(i - j);
            dia2.add(i + j);
            board[i][j] = 'Q';
            dfs(result, board, i + 1, n);
            rows.remove(i);
            cols.remove(j);
            dia1.remove(i - j);
            dia2.remove(i + j);
            board[i][j] = '.';
        }
    }

}
