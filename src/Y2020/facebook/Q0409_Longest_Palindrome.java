package Y2020.facebook;

import java.util.HashMap;
import java.util.Map;

public class Q0409_Longest_Palindrome {

    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);
        int rslt = 0;
        for (int v : map.values()) {
            rslt += v / 2 * 2;
            if (rslt % 2 == 0 && v % 2 == 1) rslt++;
        }
        return rslt;
    }

}
