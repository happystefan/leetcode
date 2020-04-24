package Y2020.facebook.graph;

import java.util.*;

public class Q0675_Cut_Off_Trees_for_Golf_Event {

    public int cutOffTree(List<List<Integer>> forest) {
        List<int[]> trees = new ArrayList<>();
        for (int i = 0; i < forest.size(); i++) {
            for (int j = 0; j < forest.get(i).size(); j++) {
                int h = forest.get(i).get(j);
                if (h > 1) trees.add(new int[]{i, j, h});
            }
        }
        Collections.sort(trees, (a, b) -> a[2] - b[2]);
        int rslt = 0;
        int i = 0, j = 0;
        for (int[] tree : trees) {
            int d = bfs(forest, i, j, tree[0], tree[1]);
            if (d == -1) return -1;
            rslt += d;
            i = tree[0];
            j = tree[1];
        }
        return rslt;
    }

    private int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    int bfs(List<List<Integer>> forest, int si, int sj, int di, int dj) {
        Queue<int[]> Q = new LinkedList<>();
        if (forest.get(si).get(sj) != 0) Q.add(new int[]{si, sj});
        boolean[][] visited = new boolean[forest.size()][forest.get(0).size()];
        visited[si][sj] = true;
        int step = 0;
        while (!Q.isEmpty()) {
            int size = Q.size();
            while (size-- > 0) {
                int[] pair = Q.poll();
                int ci = pair[0], cj = pair[1];
                if (ci == di && cj == dj) return step;
                for (int[] dir : dirs) {
                    int ni = ci + dir[0];
                    int nj = cj + dir[1];
                    if (ni < 0 || ni >= forest.size() || nj < 0 || nj >= forest.get(0).size()
                            || visited[ni][nj]
                            || forest.get(ni).get(nj) == 0) {
                        continue;
                    }
                    visited[ni][nj] = true;
                    Q.add(new int[]{ni, nj});
                }
            }
            step++;
        }
        return -1;
    }

}
