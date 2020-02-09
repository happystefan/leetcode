package Y2019.Q0001_Q0300;

public class Q0125_Valid_Palindrome {

    public boolean isPalindrome(String s) {
        char[] ss = s.toLowerCase().toCharArray();
        int i = 0, j = ss.length - 1;
        while (i < j) {
            if (!Character.isLetterOrDigit(ss[i])) i++;
            else if (!Character.isLetterOrDigit(ss[j])) j--;
            else if (ss[i] != ss[j]) return false;
            else {
                i++;
                j--;
            }
        }
        return true;
    }

}
