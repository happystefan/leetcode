package facebook;

import java.util.Arrays;

public class Q556_Next_Greater_Element_III {

    public int nextGreaterElement(int n) {
        char[] ss = String.valueOf(n).toCharArray();
        int i = ss.length - 2;
        while (i >= 0 && ss[i] >= ss[i + 1]) i--;
        if (i == -1) {
            return -1;
        }
        int j = ss.length - 1;
        while (j >= 0 && ss[j] <= ss[i]) j--;
        char t = ss[i];
        ss[i] = ss[j];
        ss[j] = t;
        Arrays.sort(ss, i + 1, ss.length);
        return Long.valueOf(new String(ss)) > Integer.MAX_VALUE ? -1 : Integer.valueOf(new String(ss));
    }

}
