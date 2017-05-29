import java.util.HashMap;

/**
 * Created by mqliang on 5/29/17.
 */
public class Q013_Roman_to_Integer {
    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap() {{
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }};

        int ans = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (map.get(s.charAt(i)) < map.get(s.charAt(i+1))) {
                ans -= map.get(s.charAt(i));
            } else {
                ans += map.get(s.charAt(i));
            }
        }
        return ans+map.get(s.charAt(s.length()-1));
    }
}
