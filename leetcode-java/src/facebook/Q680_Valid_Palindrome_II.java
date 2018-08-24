package facebook;

public class Q680_Valid_Palindrome_II {

    public boolean validPalindrome(String s) {
        char[] ss = s.toCharArray();
        int l = 0, r = ss.length-1;
        while (l < r) {
            if (ss[l] == ss[r]) {
                l++;
                r--;
            } else {
                return isPalindrome(ss, l, r-1) || isPalindrome(ss, l+1, r);
            }
        }
        return true;
    }

    private boolean isPalindrome(char[] ss, int l, int r) {
        while (l < r) {
            if (ss[l++] != ss[r--]) return false;
        }
        return true;
    }

}
