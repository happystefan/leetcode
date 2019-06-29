package Y2018.facebook;

import java.util.HashMap;
import java.util.Map;

public class Q246_Strobogrammatic_Number {

    public boolean isStrobogrammatic(String num) {
        Map<Character, Character> map = new HashMap<>();
        map.put('0', '0');
        map.put('1', '1');
        map.put('6', '9');
        map.put('8', '8');
        map.put('9', '6');
        int l = 0, r = num.length() - 1;
        while (l <= r) {
            if (l == r) {
                return num.charAt(l) == '0' || num.charAt(l) == '1' || num.charAt(l) == '8';
            } else {
                if (!map.containsKey(num.charAt(l)) || map.get(num.charAt(l)) != num.charAt(r)) {
                    return false;
                }
                l++;
                r--;
            }
        }
        return true;
    }

}
