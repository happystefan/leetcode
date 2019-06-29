package Y2018.tree;

import java.util.Arrays;

public class Q261_Graph_Valid_Tree {

    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) {
            return false;
        }
        int[] p = new int[n];
        Arrays.fill(p, -1);
        for (int[] edge : edges) {
            int px = findp(p, edge[0]), py = findp(p, edge[1]);
            if (px == py) {
                return false;
            }
            p[px] = py;
        }
        return true;
    }

    private int findp(int[] p, int x) {
        return p[x] == -1 ? x : (p[x] = findp(p, p[x]));
    }

}
