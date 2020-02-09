package Y2019.Q0601_Q0900;

import java.util.LinkedList;
import java.util.List;

public class Q0816_Ambiguous_Coordinates {

    public List<String> ambiguousCoordinates(String S) {
        S = S.substring(1, S.length() - 1);
        List<String> result = new LinkedList<>();
        for (int i = 1; i < S.length() - 1; i++) {
            String l = S.substring(0, i);
            String r = S.substring(i);
            List<String> ll = gen(l);
            List<String> rr = gen(r);
            if (!l.startsWith("0") || l.equals("0")) ll.add(l);
            if (!r.startsWith("0") || r.equals("0")) rr.add(r);
            for (String a : ll) {
                for (String b : rr) {
                    result.add(String.format("(%s, %s)", a, b));
                }
            }
        }
        return result;
    }

    private List<String> gen(String s) {
        List<String> result = new LinkedList<>();
        for (int i = 1; i < s.length(); i++) {
            String l = s.substring(0, i);
            String r = s.substring(i);
            if (l.startsWith("0") && !l.equals("0")) continue;
            if (r.endsWith("0")) continue;
            result.add(l + "." + r);
        }
        return result;
    }


}
