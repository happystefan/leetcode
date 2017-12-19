package Q200_Q299;

import java.util.Arrays;

/**
 * Created by mingqiangliang on 12/19/17.
 */
public class Q261_Graph_Valid_Tree {

    public boolean validTree(int n, int[][] edges) {
        int[] p = new int[n];
        Arrays.fill(p, -1);
        for (int i = 0; i < edges.length; i++) {
            int x = findp(p, edges[i][0]);
            int y = findp(p, edges[i][1]);
            if (x == y) return false;
            p[x] = y;
        }
        return edges.length == n-1;
    }

    public int findp(int[] p, int i) {
        return p[i]==-1 ? i : findp(p, p[i]);
    }

}
