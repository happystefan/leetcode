package Y2019.misc;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Q0009_Generate_Maze {

    // dirs: 0 - u; 1 - r; 2 - d; 3 - l
    int[][] dirs = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {-1, 0}};
    int[] prev = new int[]{2, 3, 0, 1};

    public room[][] generateMaze(int n) {
        room[][] maze = new room[n][n];
        for (int i = 0; i < n; i++) Arrays.fill(maze[i], true);
        dfs(maze, 0, 0, new boolean[n][n]);
        return maze;
    }

    private void dfs(room[][] maze, int i, int j, boolean[][] seen) {
        int n = maze.length;
        seen[i][j] = true;

        // randomize directions
        List<Integer> list = Arrays.asList(0, 1, 2, 3);
        Collections.shuffle(list);

        for (int d : list) {
            int[] dir = dirs[d];
            int ii = i + dir[0], jj = j + dir[1];
            if (ii < 0 || ii >= n || jj < 0 || jj >= n) continue;
            if (seen[ii][jj]) continue;
            maze[ii][jj].walls[d] = false;
            maze[i][j].walls[prev[d]] = false;
            dfs(maze, ii, jj, seen);
        }
    }

    class room {
        boolean[] walls;
    }

}
