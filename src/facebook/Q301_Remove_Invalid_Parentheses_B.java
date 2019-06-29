package facebook;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q301_Remove_Invalid_Parentheses_B {

    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new LinkedList<>();
        Queue<String> strQ = new LinkedList<>();
        Queue<Integer> posQ = new LinkedList<>();
        strQ.add(s);
        posQ.add(0);
        while (!strQ.isEmpty()) {
            String str = strQ.poll();
            char[] ss = str.toCharArray();
            int pos = posQ.poll();
            if (isValid(str)) {
                result.add(str);
            } else if (result.isEmpty()) {
                for (int i = pos; i < ss.length; i++) {
                    if ((ss[i] == '(' || ss[i] == ')') && (i == pos || ss[i - 1] != ss[i])) {
                        strQ.add(str.substring(0, i) + str.substring(i + 1));
                        posQ.add(i);
                    }
                }
            }
        }
        return result;
    }

    private boolean isValid(String s) {
        char[] ss = s.toCharArray();
        int l = 0;
        for (int i = 0; i < ss.length; i++) {
            if (ss[i] == '(') l++;
            else if (ss[i] == ')') l--;
            if (l < 0) return false;
        }
        return l == 0;
    }

}
