package Y2019.Q0001_Q0300;

import java.util.Arrays;

public class Q0014_Longest_Common_Prefix {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        Arrays.sort(strs);
        String a = strs[0], b = strs[strs.length - 1];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Math.min(a.length(), b.length()); i++) {
            if (a.charAt(i) != b.charAt(i)) break;
            sb.append(a.charAt(i));
        }
        return sb.toString();
    }

}
