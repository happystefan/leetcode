package Y2018.range_query;

import java.util.Arrays;

public class Q567_Permutation_in_String {

    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) {
            return false;
        }
        char[] ss = s1.toCharArray();
        Arrays.sort(ss);
        s1 = new String(ss);
        for (int i = 0; i + s1.length() <= s2.length(); i++) {
            char[] tmp = s2.substring(i, i + s1.length()).toCharArray();
            Arrays.sort(tmp);
            if (new String(tmp).equals(s1)) {
                return true;
            }
        }
        return false;
    }

}

