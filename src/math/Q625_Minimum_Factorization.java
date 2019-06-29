package math;

public class Q625_Minimum_Factorization {

    public int smallestFactorization(int a) {
        if (a < 2) {
            return a;
        }
        long result = 0, mul = 1;

        for (int i = 9; i >= 2; i--) {
            while (a % i == 0) {
                a /= i;
                result += i * mul;
                mul *= 10;
            }
        }
        return a < 2 && result <= Integer.MAX_VALUE ? (int) result : 0;
    }

}
