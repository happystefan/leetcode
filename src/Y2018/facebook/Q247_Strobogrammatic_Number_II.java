package Y2018.facebook;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Q247_Strobogrammatic_Number_II {

    private int[][] pairs = new int[][]{{0, 0}, {1, 1}, {6, 9}, {8, 8}, {9, 6}};

    public List<String> findStrobogrammatic(int n) {
        List<String> result = new LinkedList<>();
        if (n % 2 == 1) {
            for (int i : Arrays.asList(0, 1, 8)) {
                dfs(result, "" + i, n - 1);
            }
        } else {
            dfs(result, "", n);
        }
        return result;
    }

    private void dfs(List<String> result, String num, int n) {
        if (n == 0) {
            result.add(num);
            return;
        }
        for (int i = n == 2 ? 1 : 0; i < pairs.length; i++) {
            dfs(result, pairs[i][0] + num + pairs[i][1], n - 2);
        }
        return;
    }

}
