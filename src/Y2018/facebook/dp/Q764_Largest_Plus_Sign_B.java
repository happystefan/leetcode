package Y2018.facebook.dp;

import java.util.HashSet;
import java.util.Set;

public class Q764_Largest_Plus_Sign_B {

    public int orderOfLargestPlusSign(int N, int[][] mines) {
        Set<Integer> set = new HashSet<>();
        for (int[] mine : mines) set.add(mine[0] * N + mine[1]);
        int[][] up = new int[N][N];
        int[][] down = new int[N][N];
        int[][] left = new int[N][N];
        int[][] right = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == 0) up[i][j] = set.contains(i * N + j) ? 0 : 1;
                else up[i][j] = set.contains(i * N + j) ? 0 : 1 + up[i - 1][j];
            }
        }
        for (int i = N - 1; i >= 0; i--) {
            for (int j = 0; j < N; j++) {
                if (i == N - 1) down[i][j] = set.contains(i * N + j) ? 0 : 1;
                else down[i][j] = set.contains(i * N + j) ? 0 : 1 + down[i + 1][j];
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (j == 0) left[i][j] = set.contains(i * N + j) ? 0 : 1;
                else left[i][j] = set.contains(i * N + j) ? 0 : 1 + left[i][j - 1];
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = N - 1; j >= 0; j--) {
                if (j == N - 1) right[i][j] = set.contains(i * N + j) ? 0 : 1;
                else right[i][j] = set.contains(i * N + j) ? 0 : 1 + right[i][j + 1];
            }
        }
        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int l = Math.min(Math.min(up[i][j], down[i][j]), Math.min(left[i][j], right[i][j]));
                result = Math.max(result, l);
            }
        }
        return result;
    }

}
