package bfs_dfs;

import java.util.HashSet;
import java.util.Set;

public class Q533_Lonely_Pixel_II {

    public int findBlackPixel(char[][] picture, int N) {
        int m = picture.length, n = picture[0].length;
        int[] row = new int[m];
        int[] col = new int[n];

        Set<String>[] rows_table = new Set[n];
        for (int i = 0; i < n; i++) {
            rows_table[i] = new HashSet<>();
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] == 'B') {
                    row[i] += 1;
                    col[j] += 1;
                    rows_table[j].add(new String(picture[i]));
                }
            }
        }

        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] == 'B' && row[i] == N && col[j] == N && rows_table[j].size() == 1) {
                    result++;
                }
            }
        }
        return result;
    }

}
