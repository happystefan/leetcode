package facebook;

import java.math.BigInteger;
import java.util.LinkedList;

public class Q306_Additive_Number {

    public boolean isAdditiveNumber(String num) {
        return dfs(num, new LinkedList<>(), 0);
    }

    private boolean dfs(String str, LinkedList<BigInteger> list, int pos) {
        if (pos == str.length()) {
            return list.size() >= 3;
        }
        if (list.size() == 0 || list.size() == 1) {
            for (int i = pos + 1; i < str.length(); i++) {
                String sub = str.substring(pos, i);
                if (sub.charAt(0) == '0' && sub.length() > 1) {
                    break;
                }
                list.add(new BigInteger(sub));
                if (dfs(str, list, i)) {
                    return true;
                }
                list.remove(list.size() - 1);
            }
        } else {
            BigInteger sum = list.get(list.size() - 1).add(list.get(list.size() - 2));
            String expect = sum.toString();
            if (str.startsWith(expect, pos)) {
                list.add(sum);
                if (dfs(str, list, pos + expect.length())) {
                    return true;
                }
                list.remove(list.size() - 1);
            }
        }
        return false;
    }

}
