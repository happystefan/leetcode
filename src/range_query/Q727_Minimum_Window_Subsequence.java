package range_query;

public class Q727_Minimum_Window_Subsequence {

    // Time Limit Exceeded
    public String minWindow(String S, String T) {
        int l = 0, r = 0;
        String result = "";
        while (l < S.length()) {
            if (!isSubsequence(S, l, r, T) && r < S.length()) {
                r++;
            } else {
                l++;
            }
            if (isSubsequence(S, l, r, T) && (result.length() == 0 || r - l < result.length())) {
                result = S.substring(l, r);
            }
        }
        return result;
    }

    private boolean isSubsequence(String S, int l, int r, String T) {
        int j = 0;
        for (int i = l; i < r; i++) {
            if (S.charAt(i) == T.charAt(j)) {
                j++;
            }
            if (j == T.length()) {
                return true;
            }
        }
        return false;
    }

}
