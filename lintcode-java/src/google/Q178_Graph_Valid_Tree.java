package google;

import java.util.Arrays;

/**
 * Created by mingqiangliang on 12/21/17.
 */
public class Q178_Graph_Valid_Tree {

    public boolean validTree(int n, int[][] edges) {
        int[] p = new int[n];
        Arrays.fill(p, -1);
        for (int[] edge : edges) {
            int x = findp(edge[0], p);
            int y = findp(edge[1], p);
            if (x == y) return false;
            p[x] = y;
        }
        return edges.length == n-1;
    }

    public int findp(int n, int[] p) {
        return p[n] == -1 ? n : findp(p[n], p);
    }

}
