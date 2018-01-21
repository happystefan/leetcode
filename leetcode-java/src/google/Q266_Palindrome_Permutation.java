package google;

import java.util.HashMap;
import java.util.Map;

public class Q266_Palindrome_Permutation {

    public boolean canPermutePalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        int i = 0;
        for (int v : map.values()) {
            if (v%2 == 1) i++;
        }
        return i <= 1;
    }

}
