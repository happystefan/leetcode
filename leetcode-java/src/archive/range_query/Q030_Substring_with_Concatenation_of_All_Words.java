package archive.range_query;

import java.util.*;

public class Q030_Substring_with_Concatenation_of_All_Words {

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new LinkedList<>();
        if (words.length == 0) {
            return result;
        }
        Map<String, Integer> target = new HashMap<>();
        for (String word : words) {
            target.put(word, target.getOrDefault(word, 0)+1);
        }
        int step = words[0].length();
        for (int i = 0; i+step*words.length <= s.length(); i++) {
            Map<String, Integer> appear = new HashMap<>();
            int j = 0;
            while (j < words.length) {
                String word = s.substring(i+j*step, i+(j+1)*step);
                if (target.containsKey(word)) {
                    appear.put(word, appear.getOrDefault(word, 0)+1);
                    if (appear.get(word) > target.get(word)) {
                        break;
                    }
                } else {
                    break;
                }
                j++;
            }
            if (j == words.length) {
                result.add(i);
            }
        }
        return result;
    }

}
