package Y2020.facebook.bsearch;

import java.util.PriorityQueue;

public class Q0774_Minimize_Max_Distance_to_Gas_Station {

    // TLE: K*log(N)
    class solution_pq {

        public double minmaxGasDist(int[] stations, int K) {
            PriorityQueue<double[]> Q = new PriorityQueue<>((a, b) -> Double.compare(b[0] / b[1], a[0] / a[1]));
            for (int i = 1; i < stations.length; i++) {
                Q.add(new double[]{stations[i] - stations[i - 1], 1.0});
            }
            while (K-- > 0) {
                double[] curr = Q.poll();
                curr[1]++;
                Q.add(curr);
            }
            return Q.peek()[0] / Q.peek()[1];
        }

    }

    class solution_bsearch {

        public double minmaxGasDist(int[] stations, int K) {
            double l = 0, r = stations[stations.length - 1] - stations[0];
            while (r - l > 1e-6) {
                double m = (r + l) / 2;
                if (isPossible(stations, K, m)) {
                    r = m;
                } else {
                    l = m;
                }
            }
            return l;
        }

        private boolean isPossible(int[] stations, int K, double dist) {
            int cnt = 0;
            for (int i = 1; i < stations.length; i++) {
                cnt += Math.ceil((stations[i] - stations[i - 1]) / dist) - 1;
            }
            return cnt <= K;
        }

    }

}
