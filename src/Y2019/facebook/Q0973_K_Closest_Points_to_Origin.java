package Y2019.facebook;

import java.util.Arrays;

public class Q0973_K_Closest_Points_to_Origin {

    private boolean isGreateThan(int[] a, int[] b) {
        return a[0] * a[0] + a[1] * a[1] > b[0] * b[0] + b[1] * b[1];
    }

    public int[][] kClosest(int[][] points, int K) {
        int l = 0, r = points.length - 1;
        while (l < r) {
            int pi = partition(points, l, r);
            if (pi < K) l = pi + 1;
            else if (pi > K) r = pi - 1;
            else break;
        }
        return Arrays.copyOfRange(points, 0, K);
    }

    private int partition(int[][] points, int l, int r) {
        int i = l, j = r - 1;
        int[] pivot = points[r];
        while (i <= j) {
            if (isGreateThan(points[i], pivot)) {
                swap(points, i, j);
                j--;
            } else {
                i++;
            }
        }
        swap(points, i, r);
        return i;
    }

    private void swap(int[][] points, int i, int j) {
        int[] tmp = points[i];
        points[i] = points[j];
        points[j] = tmp;
    }

}
