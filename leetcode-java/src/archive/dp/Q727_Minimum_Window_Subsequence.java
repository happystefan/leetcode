package archive.dp;

public class Q727_Minimum_Window_Subsequence {

    // BinarySearch: Time Limit Exceeded
    public String minWindow(String S, String T) {
        if (S.length() < T.length()) {
            return "";
        }
        if (S.length() == T.length()) {
            return S.equals(T) ? S : "";
        }
        int l = 0, r = S.length()-1;
        String result = "";
        while (l <= r) {
            int m = l+(r-l)/2;
            boolean contains = false;
            for (int i = 0; i+m < S.length(); i++) {
                if (isSubSequence(T, S.substring(i, i+m+1))) {
                    result = S.substring(i, i+m+1);
                    contains = true;
                    break;
                }
            }
            if (contains) {
                r = m-1;
            } else {
                l = m+1;
            }
        }
        return result;
    }

    private boolean isSubSequence(String t, String s) {
        int j = 0;
        for (int i = 0; i < s.length() && j < t.length(); i++) {
            if (s.charAt(i) == t.charAt(j)) {
                j++;
            }
        }
        return j == t.length();
    }

}
