package Y2020.facebook.misc;

import java.util.LinkedList;
import java.util.Queue;

public class Q0286_Walls_and_Gates {

    int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    class solution_dfs {

        public void wallsAndGates(int[][] rooms) {
            if (rooms == null || rooms.length == 0 || rooms[0] == null || rooms[0].length == 0) return;
            int m = rooms.length, n = rooms[0].length;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (rooms[i][j] == 0) dfs(rooms, i, j, 0);
                }
            }
        }

        private void dfs(int[][] room, int i, int j, int dis) {
            room[i][j] = dis;
            for (int[] dir : dirs) {
                int ii = i + dir[0], jj = j + dir[1];
                if (ii < 0 || ii >= room.length || jj < 0 || jj >= room[0].length) continue;
                if (room[ii][jj] <= dis + 1) continue;
                dfs(room, ii, jj, dis + 1);
            }
        }

    }

    class solution_bfs {

        public void wallsAndGates(int[][] rooms) {
            if (rooms == null || rooms.length == 0 || rooms[0] == null || rooms[0].length == 0) return;
            int m = rooms.length, n = rooms[0].length;
            Queue<int[]> Q = new LinkedList<>();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (rooms[i][j] == 0) Q.add(new int[]{i, j});
                }
            }
            while (!Q.isEmpty()) {
                int[] pair = Q.poll();
                int i = pair[0], j = pair[1];
                for (int[] dir : dirs) {
                    int ii = i + dir[0], jj = j + dir[1];
                    if (ii < 0 || ii >= rooms.length || jj < 0 || jj >= rooms[0].length) continue;
                    if (rooms[ii][jj] <= rooms[i][j] + 1) continue;
                    rooms[ii][jj] = rooms[i][j] + 1;
                    Q.add(new int[]{ii, jj});
                }
            }
        }

    }

}
