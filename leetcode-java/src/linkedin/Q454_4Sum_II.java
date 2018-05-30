package linkedin;

import java.util.*;

public class Q454_4Sum_II {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Set<int[]>> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                map.computeIfAbsent(A[i]+B[j], k-> new HashSet<>());
                map.get(A[i]+B[j]).add(new int[]{i, j});
            }
        }
        int result = 0;
        for (int k = 0; k < C.length; k++) {
            for (int l = 0; l < D.length; l++) {
                if (!map.containsKey(-C[k]-D[l])) {
                    continue;
                }
                result += map.get(-C[k]-D[l]).size();
            }
        }
        return result;
    }

}
