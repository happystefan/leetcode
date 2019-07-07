package Y2019.Q0001_Q0300;

public class Q0008_String_to_Integer_atoi {

    public int myAtoi(String str) {
        str = str.trim();
        char[] ss = str.toCharArray();
        if (ss.length == 0) return 0;

        int result = 0;
        int sign = ss[0] == '-' ? -1 : 1;
        for (int i = 0; i < ss.length; i++) {
            if (i == 0 && (ss[i] == '-' || ss[i] == '+')) continue;
            if (!Character.isDigit(ss[i])) break;
            int digit = ss[i] - '0';
            if (Integer.MAX_VALUE / 10 < result || Integer.MAX_VALUE / 10 == result && digit > Integer.MAX_VALUE % 10) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = result * 10 + digit;
        }
        return result * sign;
    }

}
