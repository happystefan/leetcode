package Y2020.facebook;

public class Q0670_Maximum_Swap {

    public int maximumSwap(int num) {
        char[] ss = String.valueOf(num).toCharArray();
        int[] digits = new int[10];
        for (int i = 0; i < ss.length; i++) {
            digits[ss[i] - '0'] = i;
        }
        outer:
        for (int i = 0; i < ss.length; i++) {
            for (int d = 9; d > ss[i] - '0'; d--) {
                int j = digits[d];
                if (j > i) {
                    char tmp = ss[i];
                    ss[i] = ss[j];
                    ss[j] = tmp;
                    break outer;
                }
            }
        }
        return Integer.valueOf(new String(ss));
    }

}


