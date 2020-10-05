package Y2020.linkedin.algo_part2;

import java.util.*;

public class Q015_Reservoir_Sampling {

    class Sampling<T> {

        private List<T> rslt = new ArrayList<>();
        private int k;
        private int n = 0;
        private Random rand = new Random();

        public Sampling(int k) {
            this.k = k;
        }

        public void sample(T next) {
            n++;
            if (rslt.size() < k) rslt.add(next);
            else {
                int r = rand.nextInt(n);
                if (r < k) rslt.set(r, next);
            }
        }

        public List<T> getResult() {
            if (rslt.size() < k) throw new IllegalStateException();
            return rslt;
        }
    }
}
