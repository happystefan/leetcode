package linkedin;

import java.util.*;

public class Q288_Unique_Word_Abbreviation {

    class ValidWordAbbr {

        Map<String, Integer> map = new HashMap<>();
        Set<String> set = new HashSet<>();

        private String toAbbreviation(String str) {
            if (str == null || str.length() < 3) {
                return str;
            }
            return String.format("%c%d%c", str.charAt(0), str.length()-2, str.charAt(str.length()-1));
        }

        public ValidWordAbbr(String[] dictionary) {
            set.addAll(Arrays.asList(dictionary));
            for (String str : set) {
                String abbr = toAbbreviation(str);
                map.put(abbr, map.getOrDefault(abbr, 0)+1);
            }
        }

        public boolean isUnique(String word) {
            String abbr = toAbbreviation(word);
            return set.contains(word) && map.get(abbr) == 1 || !map.containsKey(abbr);
        }

    }

/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr obj = new ValidWordAbbr(dictionary);
 * boolean param_1 = obj.isUnique(word);
 */
}
