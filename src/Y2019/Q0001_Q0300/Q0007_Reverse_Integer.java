package Y2019.Q0001_Q0300;

public class Q0007_Reverse_Integer {

    /*
     *------------------------------------------------------------------------------------------------------------------
     *
     * solution 1: mod with long
     *
     *------------------------------------------------------------------------------------------------------------------
     */
    public int reverse(int x) {
        long result = 0;
        while (x != 0) {
            result = result * 10 + x % 10;
            if (result < Integer.MIN_VALUE || result > Integer.MAX_VALUE) return 0;
            x /= 10;
        }
        return (int) result;
    }

    /*
     *------------------------------------------------------------------------------------------------------------------
     *
     * solution 2: mod without long
     *
     *------------------------------------------------------------------------------------------------------------------
     */

    public int reverse_withoutLong(int x) {
        int currResult = 0;
        int prevResult = 0;
        while (x != 0) {
            currResult = currResult * 10 + x % 10;
            if ((currResult - x % 10) / 10 != prevResult) return 0;
            prevResult = currResult;
            x /= 10;
        }
        return currResult;
    }

    /*
     *------------------------------------------------------------------------------------------------------------------
     *
     * solution 3: StringBuilder
     *
     *------------------------------------------------------------------------------------------------------------------
     */
    public int reverse_sb(int x) {
        String str = new StringBuilder().append(Math.abs(x)).reverse().toString();
        try {
            return Integer.valueOf(str) * (x > 0 ? 1 : -1);
        } catch (Exception e) {
            return 0;
        }
    }

}
