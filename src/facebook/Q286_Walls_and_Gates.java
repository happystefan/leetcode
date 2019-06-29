package facebook;

import java.util.PriorityQueue;

public class Q286_Walls_and_Gates {

    int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0 || rooms[0] == null || rooms[0].length == 0) {
            return;
        }
        int m = rooms.length, n = rooms[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) {
                    bfs(rooms, i, j, new boolean[m][n]);
                }
            }
        }
    }

    private void bfs(int[][] rooms, int i, int j, boolean[][] visited) {
        int m = rooms.length, n = rooms[0].length;
        PriorityQueue<Node> Q = new PriorityQueue<>((a, b) -> a.d - b.d);
        Q.offer(new Node(i, j, 0));
        visited[i][j] = true;
        while (!Q.isEmpty()) {
            Node curr = Q.poll();
            int x = curr.x, y = curr.y, d = curr.d;
            if (d > rooms[x][y]) {
                continue;
            }
            rooms[x][y] = d;
            for (int[] dir : dirs) {
                int xx = x + dir[0], yy = y + dir[1];
                if (xx < 0 || xx >= m || yy < 0 || yy >= n || rooms[xx][yy] == -1 || visited[xx][yy]) {
                    continue;
                }
                Q.offer(new Node(xx, yy, d + 1));
            }
        }
    }

    class Node {
        int x, y, d;

        public Node(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }

}
