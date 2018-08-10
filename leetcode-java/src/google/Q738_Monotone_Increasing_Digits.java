package google;

import java.util.*;

public class Q738_Monotone_Increasing_Digits {

    public int monotoneIncreasingDigits(int N) {
        char[] ss = String.valueOf(N).toCharArray();
        int pos = ss.length;
        for (int i = ss.length-1; i > 0; i--) {
            if (ss[i] < ss[i-1]) {
                ss[i-1]--;
                pos = i;
            }
        }
        Arrays.fill(ss, pos, ss.length, '9');
        return Integer.parseInt(new String(ss));
    }

}
