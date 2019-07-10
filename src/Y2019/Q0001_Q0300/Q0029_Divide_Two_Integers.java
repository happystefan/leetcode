package Y2019.Q0001_Q0300;

public class Q0029_Divide_Two_Integers {

    /*
     *------------------------------------------------------------------------------------------------------------------
     *
     * solution 1: use long
     *
     *------------------------------------------------------------------------------------------------------------------
     */
    public int divide_long(int dividend, int divisor) {
        if (divisor == 0 || dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        int sign = (dividend ^ divisor) < 0 ? -1 : 1;
        long dvd = Math.abs((long) dividend);
        long dvs = Math.abs((long) divisor);
        int result = 0;
        while (dvd >= dvs) {
            long tmp = dvs, mul = 1;
            while ((tmp << 1) < dvd) {
                tmp <<= 1;
                mul <<= 1;
            }
            dvd -= tmp;
            result += mul;
        }
        return result * sign;
    }

    /*
     *------------------------------------------------------------------------------------------------------------------
     *
     * solution 2: without using long
     *
     *------------------------------------------------------------------------------------------------------------------
     */
    public int divide(int dividend, int divisor) {
        if (divisor == 0) return Integer.MAX_VALUE;
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        if (dividend == Integer.MIN_VALUE && divisor == Integer.MIN_VALUE) return 1;
        if (divisor == Integer.MIN_VALUE) return 0;

        int result = 0;
        if (dividend == Integer.MIN_VALUE) {
            result = 1;
            dividend += Math.abs(divisor);
        }

        int sign = (dividend ^ divisor) < 0 ? -1 : 1;
        int dvd = Math.abs(dividend);
        int dvs = Math.abs(divisor);

        while (dvd >= dvs) {
            long tmp = dvs, mul = 1;
            while (dvd - tmp >= tmp) { // "(tmp << 1) < dvd" here will cause overflow
                tmp <<= 1;
                mul <<= 1;
            }
            dvd -= tmp;
            result += mul;
        }
        return result * sign;
    }

}


