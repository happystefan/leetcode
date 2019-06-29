package dp;

public class Q372_Super_Pow {


    private static final int M = 1337;

    public int superPow(int a, int[] b) {
        if (a == 0) return 0;
        if (b == null || b.length == 0) return 1;
        a = a % M;
        int result = pow(a, b[b.length - 1]);
        int tmp = a;
        for (int i = b.length - 2; i >= 0; i--) {
            tmp = pow(tmp, 10);
            if (b[i] != 0)
                result = result * pow(tmp, b[i]) % M;
        }
        return result;
    }

    private int pow(int a, int b) {
        if (b == 0) {
            return 1;
        }
        if (b == 1) {
            return a;
        }
        int result = (b % 2 == 1 ? a : 1) * pow(a * a % M, b / 2) % M;
        return result;
    }

}