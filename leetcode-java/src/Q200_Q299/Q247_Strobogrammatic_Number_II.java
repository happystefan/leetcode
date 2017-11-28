package Q200_Q299;

import java.util.*;

public class Q247_Strobogrammatic_Number_II {

    public List<String> findStrobogrammatic(int n) {
        Map<Character, Character> map = new HashMap<>();
        map.put('0', '0');
        map.put('1', '1');
        map.put('8', '8');
        map.put('6', '9');
        map.put('9', '6');

        List<String> ans = new LinkedList<>();
        if (n == 0) {
            return ans;
        }
        if (n == 1) {
            ans.add("1");
            ans.add("8");
            return ans;
        }

        List<String> sublist = findSub(n-2, map);
        for (Map.Entry<Character, Character> entry : map.entrySet()) {
            if (entry.getKey() == '0') continue;
            for (String sunstr : sublist) {
                ans.add(String.format("%c%s%c", entry.getKey(), sunstr, entry.getValue()));
            }
        }
        return ans;

    }

    public List<String> findSub(int n, Map<Character, Character> map) {
        List<String> ans = new LinkedList<>();
        if (n == 0) {
            ans.add("");
            return ans;
        }
        if (n == 1) {
            ans.add("0");
            ans.add("1");
            ans.add("8");
            return ans;
        }
        if (n == 2) {
            for (Map.Entry<Character, Character> entry : map.entrySet()) {
                ans.add(String.format("%c%c", entry.getKey(), entry.getValue()));
            }
            return ans;
        }
        List<String> sublist = findSub(n-2, map);
        for (Map.Entry<Character, Character> entry : map.entrySet()) {
            for (String sunstr : sublist) {
                ans.add(String.format("%c%s%c", entry.getKey(), sunstr, entry.getValue()));
            }
        }
        return ans;
    }

}
