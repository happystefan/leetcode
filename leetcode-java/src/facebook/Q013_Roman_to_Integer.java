package facebook;

import java.util.*;

public class Q013_Roman_to_Integer {

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
        char[] ss = s.toCharArray();
        for (int i = 0; i+1 < ss.length; i++) {
            if (map.get(ss[i]) < map.get(ss[i+1])) result -= map.get(ss[i]);
            else result += map.get(ss[i]);
        }
        result += map.get(ss[ss.length-1]);
        return result;
    }

}
