package math;

public class Q008_String_to_Integer_atoi {

    public int myAtoi(String str) {
        str = str.trim();
        if (str == null || str.length() == 0) {
            return 0;
        }
        long result = 0;
        int i = 0;
        long sign = 1;
        if (str.charAt(i) == '-' || str.charAt(i) == '+') {
            if (str.charAt(i) == '-') {
                sign = -1;
            }
            i++;
        }
        for (; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                break;
            }
            result *= 10;
            result += str.charAt(i) - '0';
            if (result * sign < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            if (result * sign > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
        }
        return (int) (result * sign);
    }

}
