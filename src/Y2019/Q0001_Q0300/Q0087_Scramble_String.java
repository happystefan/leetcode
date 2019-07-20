package Y2019.Q0001_Q0300;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Q0087_Scramble_String {

    /*
     *------------------------------------------------------------------------------------------------------------------
     *
     * solution 1: recursive
     *
     *------------------------------------------------------------------------------------------------------------------
     */
    public boolean isScramble_recursive_v1(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        if (s1.equals(s2)) return true;
        char[] ss1 = s1.toCharArray(), ss2 = s2.toCharArray();
        Arrays.sort(ss1);
        Arrays.sort(ss2);
        if (!new String(ss1).equals(new String(ss2))) return false;
        int n = s1.length();
        for (int i = 1; i < n; i++) {
            if (isScramble_recursive_v1(s1.substring(0, i), s2.substring(0, i)) &&
                    isScramble_recursive_v1(s1.substring(i), s2.substring(i))) return true;
            if (isScramble_recursive_v1(s1.substring(0, i), s2.substring(n - i)) &&
                    isScramble_recursive_v1(s1.substring(i), s2.substring(0, n - i))) return true;
        }
        return false;
    }

    /*
     *------------------------------------------------------------------------------------------------------------------
     *
     * solution 2: recursive with memory
     *
     *------------------------------------------------------------------------------------------------------------------
     */
    Map<String, Boolean> map = new HashMap<>();

    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        if (s1.equals(s2)) return true;
        char[] ss1 = s1.toCharArray(), ss2 = s2.toCharArray();
        Arrays.sort(ss1);
        Arrays.sort(ss2);
        if (!new String(ss1).equals(new String(ss2))) return false;
        if (map.containsKey(s1 + "#" + s2)) return map.get(s1 + "#" + s2);
        int n = s1.length();
        for (int i = 1; i < n; i++) {
            if (isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i)) ||
                    isScramble(s1.substring(0, i), s2.substring(n - i)) && isScramble(s1.substring(i), s2.substring(0, n - i))) {
                map.put(s1 + "#" + s2, true);
                return true;
            }
        }
        return false;
    }

}
