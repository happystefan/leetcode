package Y2020.facebook;

public class Q0625_Minimum_Factorization {

    public int smallestFactorization(int a) {
        if (a < 10) return a;
        long rslt = 0, mul = 1;
        for (int i = 9; i >= 2; i--) {
            while (a % i == 0) {
                rslt = i * mul + rslt;
                a /= i;
                mul *= 10;
            }
        }
        return a == 1 && rslt <= Integer.MAX_VALUE ? (int) rslt : 0;
    }

}
