package archive.misc;

import java.util.*;

public class Q011_Flower_Blooming_Groups {

    public int solution(int[] A, int K, int M) {
        // write your code in Java SE 8
        int N = A.length;
        if (N < M*K+(M-1)) {
            return -1;
        }
        // (key, value) in the map denote the blooming group:
        // key: starting position of blooming group (inclusive)
        // value: ending position of blooming group (inclusive)
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(1, N);
        int longGroupNum = 1;
        for (int i = N-1; i >= 0; i--) {
            if (longGroupNum == M) {
                return i+1;
            }
            int floorKey = map.floorKey(A[i]);
            int pos_i = floorKey, pos_j = map.get(floorKey);

            map.remove(pos_i);
            if (pos_j-pos_i+1 >= K) {
                longGroupNum--;
            }

            if (pos_i == pos_j) {
                // only one flower in this blooming group, do nothing here
            } else if (pos_i == A[i]) {
                map.put(pos_i+1, pos_j);
                if (pos_j-pos_i >= K) {
                    longGroupNum++;
                }
            } else if (pos_j == A[i]) {
                map.put(pos_i, pos_j-1);
                if (pos_j-pos_i >= K) {
                    longGroupNum++;
                }
            } else {
                map.put(pos_i, A[i]-1);
                map.put(A[i]+1, pos_j);
                if (A[i]-pos_i >= K) {
                    longGroupNum++;
                }
                if (pos_j-A[i] >= K) {
                    longGroupNum++;
                }
            }
        }
        return -1;
    }

}
