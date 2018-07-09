package bfs_dfs;

import java.util.*;

public class Q301_Remove_Invalid_Parentheses_C {

    public List<String> removeInvalidParentheses(String s) {
        Queue<String> StrQ = new LinkedList<>();
        Queue<Integer>PosQ = new LinkedList<>();
        StrQ.offer(s);
        PosQ.offer(0);
        List<String> result = new LinkedList<>();
        while (!StrQ.isEmpty()) {
            String str = StrQ.poll();
            int pos = PosQ.poll();
            if (isValid(str)) {
                result.add(str);
            } else if (result.isEmpty()) {
                for (int i = pos; i < str.length(); i++) {
                    if ((str.charAt(i) == ')' || str.charAt(i) == '(') && (i == pos || str.charAt(i) != str.charAt(i-1))) {
                        StrQ.offer(str.substring(0, i)+str.substring(i+1));
                        PosQ.offer(i);
                    }
                }
            }
        }
        return result;
    }

    private boolean isValid(String s) {
        int sum = 0;
        for(char c : s.toCharArray()) {
            if(c == '(') {
                sum++;
            } else if (c == ')') {
                sum--;
            }
            if(sum < 0) {
                return false;
            }
        }
        return sum == 0;
    }
}
