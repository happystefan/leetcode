package facebook;

public class Q680_Valid_Palindrome_II {

    public boolean validPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r && s.charAt(l) == s.charAt(r)) {
            l++;
            r--;
        }
        if (l == r) {
            return true;
        }
        return isPalindrome(s, l + 1, r) || isPalindrome(s, l, r - 1);
    }

    private boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

}
