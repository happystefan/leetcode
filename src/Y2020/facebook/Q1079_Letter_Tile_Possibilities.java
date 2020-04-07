package Y2020.facebook;

import java.util.Arrays;

public class Q1079_Letter_Tile_Possibilities {

    public int numTilePossibilities(String tiles) {
        char[] ss = tiles.toCharArray();
        Arrays.sort(ss);
        int[] rslt = new int[]{0};
        dfs(rslt, ss, new boolean[ss.length]);
        return rslt[0];
    }

    private void dfs(int[] rslt, char[] ss, boolean[] used) {
        for (int i = 0; i < ss.length; i++) {
            if (used[i]) continue;
            rslt[0]++;
            used[i] = true;
            dfs(rslt, ss, used);
            used[i] = false;
            while (i + 1 < ss.length && ss[i + 1] == ss[i]) i++;
        }
    }

}
