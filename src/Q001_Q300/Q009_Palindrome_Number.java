package Q001_Q300;

/**
 * Created by mqliang on 5/27/17.
 */
public class Q009_Palindrome_Number {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        int xx = x;
        int yy = 0;
        while (x != 0) {
            yy *= 10;
            yy += x % 10;
            x /= 10;
        }
        return xx == yy;
    }
}
