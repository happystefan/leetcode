package Y2020.facebook.misc;

public class Q0125_Valid_Palindrome {

    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) return true;
        char[] ss = s.toCharArray();
        int l = 0, r = ss.length - 1;
        while (l < r) {
            if (ss[l] != ss[r]) return false;
            l++;
            r--;
        }
        return true;
    }

}
