package Y2018.bfs_dfs;

public class Q733_Flood_Fill {

    private int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        dfs(image, sr, sc, newColor);
        return image;
    }

    private void dfs(int[][] image, int i, int j, int v) {
        int m = image.length, n = image[0].length;
        int pv = image[i][j];
        image[i][j] = v;
        for (int[] dir : dirs) {
            int ii = i + dir[0], jj = j + dir[1];
            if (ii < 0 || ii >= m || jj < 0 || jj >= n || image[ii][jj] == v || image[ii][jj] != pv) {
                continue;
            }
            dfs(image, ii, jj, v);
        }
    }

}
