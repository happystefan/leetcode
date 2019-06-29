package Q001_Q300;

public class Q125_Valid_Palindrome {

    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) return true;

        int i = 0, j = s.length() - 1;
        while (true) {
            while (i < s.length() - 1 && !Character.isLetterOrDigit(s.charAt(i))) i++;
            while (j > 0 && !Character.isLetterOrDigit(s.charAt(j))) j--;
            if (i > j) break;
            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) return false;
            i++;
            j--;
        }
        return true;
    }

}
