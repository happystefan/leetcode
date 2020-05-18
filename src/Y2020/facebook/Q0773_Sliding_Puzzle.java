package Y2020.facebook;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Q0773_Sliding_Puzzle {

    public int slidingPuzzle(int[][] board) {
        String dst = "123450";
        String src = "";
        for (int[] b : board) {
            for (int i : b) src += i;
        }
        int[][] dirs = new int[][]{
                {1, 3},
                {0, 2, 4},
                {1, 5},
                {0, 4},
                {1, 3, 5},
                {2, 4},
        };
        Queue<String> Q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        Q.add(src);
        visited.add(src);
        int rslt = 0;
        while (!Q.isEmpty()) {
            int size = Q.size();
            while (size-- > 0) {
                String cur = Q.poll();
                if (cur.equals(dst)) return rslt;
                int i = cur.indexOf("0");
                for (int j : dirs[i]) {
                    String nxt = swap(cur, i, j);
                    if (visited.contains(nxt)) continue;
                    Q.add(nxt);
                    visited.add(nxt);
                }
            }
            rslt++;
        }
        return -1;
    }

    private String swap(String str, int i, int j) {
        char[] ss = str.toCharArray();
        char tmp = ss[i];
        ss[i] = ss[j];
        ss[j] = tmp;
        return String.valueOf(ss);
    }

}
