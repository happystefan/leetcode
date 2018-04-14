package facebook;

import java.util.HashMap;
import java.util.Map;

public class Q419_Roman_to_Integer {

    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('X', 10);
        map.put('C', 100);
        map.put('M', 1000);
        map.put('V', 5);
        map.put('L', 50);
        map.put('D', 500);

        char[] ss = s.toCharArray();
        int result = 0;
        for (int i = 0; i < ss.length-1; i++) {
            if (map.get(ss[i]) >= map.get(ss[i+1])) {
                result += map.get(ss[i]);
            } else {
                result -= map.get(ss[i]);
            }
        }
        return result + map.get(ss[ss.length-1]);
    }

}

