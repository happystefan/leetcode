package Y2018.backtracking;

import java.util.HashMap;
import java.util.Map;

public class Q383_Ransom_Note {

    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> target = new HashMap<>();
        Map<Character, Integer> dict = new HashMap<>();
        for (char c : ransomNote.toCharArray()) {
            target.put(c, target.getOrDefault(c, 0) + 1);
        }
        for (char c : magazine.toCharArray()) {
            dict.put(c, dict.getOrDefault(c, 0) + 1);
        }
        for (char c : target.keySet()) {
            if (dict.getOrDefault(c, 0) < target.get(c)) {
                return false;
            }
        }
        return true;
    }

}
