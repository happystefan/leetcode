package Y2020.facebook;

public class Q680_Valid_Palindrome_II {

    public boolean validPalindrome(String s) {
        if (s == null || s.length() == 0) return false;
        return isValid(s.toCharArray(), 0, s.length() - 1, true);
    }

    private boolean isValid(char[] ss, int i, int j, boolean firstCall) {
        while (i < j && ss[i] == ss[j]) {
            i++;
            j--;
        }
        if (i >= j) return true;
        if (!firstCall) return false;
        return isValid(ss, i + 1, j, false) || isValid(ss, i, j - 1, false);
    }

}
