package facebook;

public class Q029_Divide_Two_Integers {

    public int divide(int dividend, int divisor) {
        if (divisor == 0 || dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        int sign = (dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0) ? 1 : -1;
        long dvd = Math.abs((long) dividend);
        long dvs = Math.abs((long) divisor);
        int result = 0;
        while (dvd >= dvs) {
            long tmp = dvs, mul = 1;
            while (dvd >= (tmp << 1)) {
                tmp <<= 1;
                mul <<= 1;
            }
            dvd -= tmp;
            result += mul;
        }
        return result * sign;
    }

}
