package dp;

public class Q214_Shortest_Palindrome_B {

    public String shortestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        int idx = s.length()-1;
        while (!isPalindrome(s, 0, idx)) {
            idx--;
        }
        return new StringBuilder(s.substring(idx+1)).reverse().toString()+s;
    }

    private boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

}
