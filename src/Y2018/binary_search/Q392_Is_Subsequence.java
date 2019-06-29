package Y2018.binary_search;

public class Q392_Is_Subsequence {

    public boolean isSubsequence(String s, String t) {
        int j = 0;
        for (int i = 0; i < t.length() && j < s.length(); i++) {
            if (s.charAt(j) == t.charAt(i)) {
                j++;
            }
        }
        return j == s.length();
    }

}
