package facebook;

public class Q178_Graph_Valid_Tree {
    // union found with path compression
    public boolean validTree(int n, int[][] edges) {
        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = i;
        }

        for (int[] edge : edges) {
            int x = findp(edge[0], p);
            int y = findp(edge[1], p);
            if (x == y) {
                return false;
            }
            p[x] = y;
        }
        return edges.length == n-1;

    }

    private int findp(int n, int[] p) {
        if (p[n] != n) {
            p[n] = findp(p[n], p);
        }
        return p[n];
    }

}
