package Y2020.facebook;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Q0973_K_Closest_Points_to_Origin {

    class solution1_quick_select {

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
                if (isGreaterThan(points[i], pivot)) {
                    swap(points, i, j);
                    j--;
                } else {
                    i++;
                }
            }
            swap(points, i, r);
            return i;
        }

        private boolean isGreaterThan(int[] a, int[] b) {
            return a[0] * a[0] + a[1] * a[1] > b[0] * b[0] + b[1] * b[1];
        }

        private void swap(int[][] points, int i, int j) {
            int[] tmp = points[i];
            points[i] = points[j];
            points[j] = tmp;
        }

    }

    class solution2_priority_queue {

        public int[][] kClosest(int[][] points, int K) {
            PriorityQueue<int[]> Q = new PriorityQueue<>((a, b) ->
                    b[0] * b[0] + b[1] * b[1] - a[0] * a[0] - a[1] * a[1]);
            for (int[] p : points) {
                Q.add(p);
                if (Q.size() > K) Q.poll();
            }
            int[][] rslt = new int[K][2];
            int i = 0;
            while (!Q.isEmpty()) rslt[i++] = Q.poll();
            return rslt;
        }

    }


}