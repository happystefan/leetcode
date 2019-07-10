package Y2019.Q0301_Q0600;

public class Q0509_Fibonacci_Number {

    public int fib(int N) {
        if (N <= 1) return N;
        int[][] u = new int[][]{{1, 1}, {1, 0}};
        int[][] f = new int[][]{{1, 0}};
        u = pow(u, N - 1);
        f = mul(f, u);
        return f[0][0];
    }

    private int[][] pow(int[][] m, int n) {
        if (n == 1) return m;
        if (n % 2 == 1) return mul(pow(m, n - 1), m);
        int[][] tmp = pow(m, n >> 1);
        return mul(tmp, tmp);
    }

    private int[][] mul(int[][] a, int[][] b) {
        int m = a.length, n = b[0].length;
        int[][] c = new int[m][n];
        for (int k = 0; k < a[0].length; k++) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    c[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return c;
    }

}
