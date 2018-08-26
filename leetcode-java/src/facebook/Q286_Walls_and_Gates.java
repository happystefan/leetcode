package facebook;

import java.util.*;

public class Q286_Walls_and_Gates {

    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0 || rooms[0] == null || rooms[0].length == 0) return;
        int m = rooms.length, n = rooms[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] != 0) continue;
                bfs(rooms, i, j);
            }
        }
        return;
    }

    int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private void bfs(int[][] rooms, int x, int y) {
        int m = rooms.length, n = rooms[0].length;
        Queue<int[]> Q = new LinkedList<>();
        int dis = 0;
        Q.offer(new int[]{x, y});
        while (!Q.isEmpty()) {
            int size = Q.size();
            dis++;
            while (size-- > 0) {
                int i = Q.peek()[0], j = Q.peek()[1];
                Q.poll();
                for (int[] dir : dirs) {
                    int ii = i + dir[0], jj = j + dir[1];
                    if (ii < 0 || ii >= m || jj < 0 || jj >= n) continue;
                    if (rooms[ii][jj] <= dis) continue;
                    rooms[ii][jj] = dis;
                    Q.offer(new int[]{ii, jj});
                }
            }
        }
    }

}
