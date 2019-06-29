package Y2018.oa.twitter;

import java.util.LinkedList;
import java.util.List;

public class No_Pairs_Allowed {

    static List<Integer> minimalOperations(List<String> words) {
        List<Integer> result = new LinkedList<>();
        if (words == null || words.size() == 0) return result;
        for (String word : words) {
            result.add(minOpt(word));
        }
        return result;
    }

    static int minOpt(String word) {
        if (word == null || word.length() == 0) return 0;
        int result = 0;
        int l = 0, r = 0;
        while (r < word.length()) {
            while (r < word.length() && word.charAt(r) == word.charAt(l)) r++;
            result += (r - l) / 2;
            l = r;
        }
        return result;
    }

}
