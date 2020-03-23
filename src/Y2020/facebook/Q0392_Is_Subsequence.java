package Y2020.facebook;

public class Q0392_Is_Subsequence {

    public boolean isSubsequence(String s, String t) {
        if (s == null || s.length() == 0) return true;
        int i = 0;
        for (char c : t.toCharArray()) {
            if (c == s.charAt(i)) i++;
            if (i == s.length()) return true;
        }
        return false;
    }

}
