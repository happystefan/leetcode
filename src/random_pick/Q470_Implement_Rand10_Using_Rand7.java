package random_pick;

import java.util.Random;

public class Q470_Implement_Rand10_Using_Rand7 {

    class SolBase {
        Random random = new Random();

        public int rand7() {
            return 1 + random.nextInt(7);
        }
    }

    /**
     * The rand7() API is already defined in the parent class SolBase.
     * public int rand7();
     *
     * @return a random integer in the range 1 to 7
     */
    class Solution extends SolBase {
        public int rand10() {
            int i, j;
            do { // P(i is even) = P(i is odd) = 0.5
                i = rand7();
            } while (i > 6);
            do {
                j = rand7();
            } while (j > 5); // P(j==1) = P(j==2) = P(j==3) = P(j==4) = P(j==5) = 0.2
            return (i % 2 == 0) ? j : j + 5;
        }
    }

}
