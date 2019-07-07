package Y2019.Q0001_Q0300;

public class Q0009_Palindrome_Number {

    /*
     *------------------------------------------------------------------------------------------------------------------
     *
     * solution 1: StringBuilder
     *
     *------------------------------------------------------------------------------------------------------------------
     */
    public boolean isPalindrome_sb(int x) {
        return String.valueOf(x).equals(new StringBuilder().append(x).reverse().toString());
    }

    /*
     *------------------------------------------------------------------------------------------------------------------
     *
     * solution 2: revert int
     *
     *------------------------------------------------------------------------------------------------------------------
     */
    public boolean isPalindrome_ri(int x) {
        if (x < 0) return false;
        int xx = x;
        int yy = 0;
        while (x != 0) {
            yy = yy * 10 + x %10;
            x /= 10;
        }
        return xx == yy;
    }

}
