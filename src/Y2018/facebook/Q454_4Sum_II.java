package Y2018.facebook;

import java.util.HashMap;
import java.util.Map;

public class Q454_4Sum_II {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                map1.put(A[i] + B[j], map1.getOrDefault(A[i] + B[j], 0) + 1);
            }
        }
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                map2.put(C[i] + D[j], map2.getOrDefault(C[i] + D[j], 0) + 1);
            }
        }
        int result = 0;
        for (int ab : map1.keySet()) {
            if (!map2.containsKey(-ab)) continue;
            result += map1.get(ab) * map2.get(-ab);
        }
        return result;
    }

}
