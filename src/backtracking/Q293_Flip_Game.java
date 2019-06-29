package backtracking;

import java.util.LinkedList;
import java.util.List;

public class Q293_Flip_Game {

    public List<String> generatePossibleNextMoves(String s) {
        char[] ss = s.toCharArray();
        List<String> result = new LinkedList<>();
        for (int i = 1; i < ss.length; i++) {
            if (ss[i] == ss[i - 1] && ss[i] == '+') {
                ss[i - 1] = ss[i] = '-';
                result.add(new String(ss));
                ss[i - 1] = ss[i] = '+';
            }
        }
        return result;
    }

}
