package Y2018.google;

import java.util.PriorityQueue;

public class Q313_Super_Ugly_Number_C {

    public int nthSuperUglyNumber(int n, int[] primes) {
        PriorityQueue<Long> Q = new PriorityQueue<>();
        Q.offer(1l);
        while (n-- > 1) {
            long c = Q.poll();
            while (!Q.isEmpty() && Q.peek() == c) {
                Q.poll();
            }
            for (int i : primes) {
                Q.offer(i * c);
            }
        }
        return Q.poll().intValue();
    }

}
