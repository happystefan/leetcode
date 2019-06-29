package divide_and_conquer;

import java.util.*;

public class Q726_Number_of_Atoms_B {

    public String countOfAtoms(String formula) {
        int N = formula.length();
        Stack<Map<String, Integer>> stack = new Stack();
        stack.push(new HashMap<>());

        for (int i = 0; i < N; ) {
            if (formula.charAt(i) == '(') {
                stack.push(new HashMap<>());
                i++;
            } else if (formula.charAt(i) == ')') {
                Map<String, Integer> top = stack.pop();
                int iStart = ++i, cnt = 1;
                while (i < N && Character.isDigit(formula.charAt(i))) i++;
                if (i > iStart) cnt = Integer.parseInt(formula.substring(iStart, i));
                for (String c : top.keySet()) {
                    int v = top.get(c);
                    stack.peek().put(c, stack.peek().getOrDefault(c, 0) + v * cnt);
                }
            } else {
                int iStart = i++;
                while (i < N && Character.isLowerCase(formula.charAt(i))) i++;
                String name = formula.substring(iStart, i);
                iStart = i;
                while (i < N && Character.isDigit(formula.charAt(i))) i++;
                int cnt = i > iStart ? Integer.parseInt(formula.substring(iStart, i)) : 1;
                stack.peek().put(name, stack.peek().getOrDefault(name, 0) + cnt);
            }
        }

        StringBuilder ans = new StringBuilder();
        ArrayList<String> names = new ArrayList<>(stack.peek().keySet());
        Collections.sort(names);
        for (String name : names) {
            ans.append(name);
            int cnt = stack.peek().get(name);
            if (cnt > 1) ans.append(cnt);
        }
        return new String(ans);
    }

}
