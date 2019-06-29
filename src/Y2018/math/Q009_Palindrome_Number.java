package Y2018.math;

public class Q009_Palindrome_Number {

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int cnt = 0;
        int xx = x;
        while (xx != 0) {
            cnt += 1;
            xx /= 10;
        }
        while (cnt > 1) {
            int magnitude = 1;
            for (int i = 0; i < cnt - 1; i++) {
                magnitude *= 10;
            }
            if (x % 10 != x / (magnitude)) {
                return false;
            }
            x %= magnitude;
            x /= 10;
            cnt -= 2;
        }
        return true;
    }

}
