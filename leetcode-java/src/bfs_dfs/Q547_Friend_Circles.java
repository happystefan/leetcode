package bfs_dfs;

public class Q547_Friend_Circles {

    public int findCircleNum(int[][] M) {
        int n = M.length;
        boolean[] visited = new boolean[n];
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }
            dfs(M, i, visited);
            result++;
        }
        return result;
    }

    private void dfs(int[][] M, int u, boolean[] visited) {
        visited[u] = true;
        for (int v = 0; v < M.length; v++) {
            if (M[u][v] == 1 && !visited[v]) {
                dfs(M, v, visited);
            }
        }
    }

}
