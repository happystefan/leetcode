package Y2018.tree;

public class Q684_Redundant_Connection_B {

    public int[] findRedundantConnection(int[][] edges) {
        int[] p = new int[edges.length + 1];
        for (int i = 0; i < p.length; i++) {
            p[i] = i;
        }
        for (int[] edge : edges) {
            int pu = findp(p, edge[0]), pv = findp(p, edge[1]);
            if (pu == pv) {
                return edge;
            }
            p[pu] = pv;
        }
        return null;
    }

    private int findp(int[] p, int x) {
        if (p[x] != x) {
            p[x] = findp(p, p[x]);
        }
        return p[x];
    }

}
