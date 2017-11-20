package Q001_Q099;

/**
 * Created by mqliang on 5/27/17.
 */
public class Q010_Regular_Expression_Matching {
    public boolean isMatch(String s, String p) {
        int lens = 0, lenp = 0;
        if (s != null) lens = s.length();
        if (p != null) lenp = p.length();

        if (lenp == 0) return lens == 0;
        if (lenp == 1) return lens == 1 && isFirstMatch(s, p);

        if (p.charAt(1) == '*') {
            return isMatch(s, p.substring(2)) || lens != 0 && isFirstMatch(s, p) && isMatch(s.substring(1), p);
        } else {
            return lens != 0 && isFirstMatch(s, p) && isMatch(s.substring(1), p.substring(1));
        }
    }

    public static boolean isFirstMatch(String s, String p) {
        return p.charAt(0)  == s.charAt(0) || p.charAt(0) == '.';
    }
}
