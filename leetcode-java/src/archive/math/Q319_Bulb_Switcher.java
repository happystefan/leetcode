package archive.math;

public class Q319_Bulb_Switcher {

    // simulating: Time Limit Exceeded
    public int bulbSwitch(int n) {
        if (n == 0) {
            return 0;
        }
        boolean[] f = new boolean[n+1];
        for (int r = 1; r <= n; r++) {
            for (int i = 1; i <= n; i++) {
                if (i%r == 0) {
                    f[i] = !f[i];
                }
            }
        }
        int result = 0;
        for (int i = 1; i <= n; i++) {
            if (f[i]) {
                result++;
            }
        }
        return result;
    }

}
