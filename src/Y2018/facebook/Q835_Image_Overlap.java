package Y2018.facebook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q835_Image_Overlap {

    public int largestOverlap(int[][] A, int[][] B) {
        int n = A.length;
        List<Integer> aa = new ArrayList<>(n * n);
        List<Integer> bb = new ArrayList<>(n * n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (A[i][j] == 1) {
                    aa.add(i * 100 + j);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (B[i][j] == 1) {
                    bb.add(i * 100 + j);
                }
            }
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : aa) {
            for (int j : bb) {
                map.put(i - j, map.getOrDefault(i - j, 0) + 1);
            }
        }
        int result = 0;
        for (int i : map.values()) {
            result = Integer.max(result, i);
        }
        return result;
    }

}
