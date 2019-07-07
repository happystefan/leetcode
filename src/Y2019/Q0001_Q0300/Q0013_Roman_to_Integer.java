package Y2019.Q0001_Q0300;

import java.util.HashMap;
import java.util.Map;

public class Q0013_Roman_to_Integer {

    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int result = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            result += map.get(s.charAt(i)) * (map.get(s.charAt(i)) < map.get(s.charAt(i + 1)) ? -1 : 1);
        }
        result += map.get(s.charAt(s.length() - 1));
        return result;
    }

}
