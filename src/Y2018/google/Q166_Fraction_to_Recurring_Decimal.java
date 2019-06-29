package Y2018.google;

import java.util.HashMap;
import java.util.Map;

public class Q166_Fraction_to_Recurring_Decimal {

    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }

        StringBuilder ans = new StringBuilder();
        long num = Math.abs((long) numerator), den = Math.abs((long) denominator);
        if (numerator > 0 && denominator < 0 || numerator < 0 && denominator > 0) {
            ans.append("-");
        }
        ans.append(num / den);
        num %= den;
        if (num == 0) {
            return ans.toString();
        }

        ans.append(".");
        Map<Long, Integer> map = new HashMap<>();
        map.put(num, ans.length());
        while (num != 0) {
            num *= 10;
            ans.append(num / den);
            num %= den;
            if (map.containsKey(num)) {
                ans.insert(map.get(num), "(");
                ans.append(")");
                break;
            }
            map.put(num, ans.length());
        }
        return ans.toString();
    }

}
