package Y2020.facebook;

import java.util.HashMap;
import java.util.Map;

public class Q0266_Palindrome_Permutation {

    public boolean canPermutePalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);
        boolean flag = false;
        for (int v : map.values()) {
            if (v % 2 == 1) {
                if (flag) return false;
                flag = true;
            }
        }
        return true;
    }

}
