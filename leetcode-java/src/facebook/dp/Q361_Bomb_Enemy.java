package facebook.dp;

public class Q361_Bomb_Enemy {

    public int maxKilledEnemies(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        int[][] left = new int[m][n];
        int[][] right= new int[m][n];
        int[][] up = new int[m][n];
        int[][] down = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) left[i][j] = grid[i][j] == 'E' ? 1 : 0;
                else left[i][j] = grid[i][j] == 'W' ? 0 : (left[i][j-1] + (grid[i][j] == 'E' ? 1 : 0));

                if (i == 0) up[i][j] = grid[i][j] == 'E' ? 1 : 0;
                else up[i][j] = grid[i][j] == 'W' ? 0 : (up[i-1][j] + (grid[i][j] == 'E' ? 1 : 0));
            }
        }
        for (int i = m-1; i >= 0; i--) {
            for (int j = n-1; j >= 0; j--) {
                if (j == n-1) right[i][j] = grid[i][j] == 'E' ? 1 : 0;
                else right[i][j] = grid[i][j] == 'W' ? 0 : (right[i][j+1] + (grid[i][j] == 'E' ? 1 : 0));

                if (i == m-1) down[i][j] = grid[i][j] == 'E' ? 1 : 0;
                else down[i][j] = grid[i][j] == 'W' ? 0 : (down[i+1][j] + (grid[i][j] == 'E' ? 1 : 0));
            }
        }
        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != '0') continue;
                result = Math.max(result, left[i][j]+right[i][j]+up[i][j]+down[i][j]);
            }
        }
        return result;
    }

}
