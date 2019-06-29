package Q001_Q300;

/**
 * Created by mqliang on 5/27/17.
 */
public class Q008_String_to_Integer_atoi {
    public int myAtoi(String str) {
        if (str == null) {
            return 0;
        }

        str = str.trim();
        if (str.length() == 0) {
            return 0;
        }

        long ans = 0, sign = 1;
        int i = 0;
        if (str.charAt(0) == '-' || str.charAt(0) == '+') {
            if (str.charAt(0) == '-') sign = -1;
            i++;
        }

        for (; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return (int) (sign * ans);
            }

            ans *= 10;
            ans += str.charAt(i) - '0';
            if (sign * ans < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            if (sign * ans > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
        }
        return (int) (sign * ans);
    }
}
