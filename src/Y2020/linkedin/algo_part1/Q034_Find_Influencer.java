package Y2020.linkedin.algo_part1;

import java.util.LinkedList;
import java.util.List;

public class Q034_Find_Influencer {

    // matrix[i][j] : i is following j
    int getInfluencer(boolean[][] matrix) {
        if (matrix == null || matrix.length ==  0
                || matrix[0] == null || matrix[0].length == 0) {
            return -1;
        }
        List<Integer> candidates = new LinkedList<>();
        for (int i = 0; i < matrix.length; i++) {
            candidates.add(i);
        }
        while (candidates.size() > 1) {
            int a = candidates.get(0);
            int b = candidates.get(1);
            if (matrix[a][b]) candidates.remove(0);
            else candidates.remove(1);
        }
        // do final check in case of there is no influencer.
        int rslt = candidates.get(0);
        for (int i = 0; i < matrix.length; i++) {
            if  (i == rslt) continue;
            if (matrix[rslt][i]) return -1;
        }
        return rslt;
    }
}
