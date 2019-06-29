package Y2018.Q001_Q300;

import java.util.Arrays;

/**
 * Created by mqliang on 5/29/17.
 */
public class Q014_Longest_Common_Prefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        Arrays.sort(strs);
        String a = strs[0];
        String b = strs[strs.length - 1];

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < a.length(); i++) {
            if (i < b.length() && a.charAt(i) == b.charAt(i)) {
                ans.append(a.charAt(i));
            } else {
                return ans.toString();
            }
        }
        return ans.toString();
    }
}
