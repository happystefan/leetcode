package oa.twitter;

import java.util.LinkedList;
import java.util.List;

public class Missing_Words {

    public static List<String> missingWords(String s, String t) {
        // Write your code here
        List<String> result = new LinkedList<>();
        String[] ss = s.split(" ");
        String[] tt = t.split(" ");
        int i = 0, j = 0;
        while (i < ss.length && j < tt.length) {
            if (tt[j].equals(ss[i])) {
                i++;
                j++;
            } else {
                result.add(ss[i]);
                i++;
            }
        }
        while (i < ss.length) {
            result.add(ss[i++]);
        }
        return result;
    }

}
