package archive.facebook;

import java.util.*;

public class Q842_Split_Array_into_Fibonacci_Sequence {

    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> result = new LinkedList<>();
        dfs(result, new LinkedList<>(), S, 0);
        return result;
    }

    private void dfs(List<Integer> result, List<Integer> list, String str, int pos) {
        if (pos == str.length() && result.size() >= 3) {
            return;
        }
        if (pos == str.length()) {
            if (list.size() >= 3) {
                result.addAll(list);
            }
            return;
        }
        if (list.size() == 0 || list.size() == 1) {
            for (int i = pos+1; i < str.length(); i++) {
                String sub = str.substring(pos, i);
                if (sub.charAt(0) == '0' && sub.length() > 1) {
                    continue;
                }
                long num = Long.valueOf(sub);
                if (num > Integer.MAX_VALUE) {
                    break;
                }
                list.add((int)num);
                dfs(result, list, str, i);
                list.remove(list.size()-1);
            }
        } else {
            int expect = list.get(list.size() - 1) + list.get(list.size() - 2);
            if (str.startsWith(String.valueOf(expect), pos)) {
                list.add(expect);
                dfs(result, list, str, pos + String.valueOf(expect).length());
                list.remove(list.size()-1);
            }
        }
    }

}
