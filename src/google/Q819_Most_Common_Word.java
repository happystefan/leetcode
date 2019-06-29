package google;

import java.util.*;

public class Q819_Most_Common_Word {

    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> set = new HashSet<>(Arrays.asList(banned));
        Map<String, Integer> map = new HashMap<>();
        int max = 0;
        String result = "";
        for (String str : paragraph.replaceAll("\\pP", " ").toLowerCase().split("\\s+")) {
            if (set.contains(str)) {
                continue;
            }
            map.put(str, map.getOrDefault(str, 0) + 1);
            if (map.get(str) > max) {
                max = map.get(str);
                result = str;
            }
        }
        return result;
    }

}
