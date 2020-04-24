package Y2020.facebook.misc;

public class Q0680_Valid_Palindrome_II {

    public boolean validPalindrome(String s) {
        if (s == null || s.length() == 0) return true;
        return isValid(s.toCharArray(), 0, s.length() - 1, 1);
    }

    private boolean isValid(char[] ss, int l, int r, int cnt) {
        while (l <= r && ss[l] == ss[r]) {
            l++;
            r--;
        }
        if (l > r) return true;
        if (cnt == 0) return false;
        return isValid(ss, l + 1, r, 0) || isValid(ss, l, r - 1, 0);
    }

}
