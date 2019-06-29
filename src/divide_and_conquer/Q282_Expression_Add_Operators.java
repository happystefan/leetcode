package divide_and_conquer;

import java.util.LinkedList;
import java.util.List;

public class Q282_Expression_Add_Operators {

    public List<String> addOperators(String num, int target) {
        List<String> result = new LinkedList<>();
        if (num == null || num.length() == 0) {
            return result;
        }
        dfs(result, num, "", 0, 0, target);
        return result;
    }

    private void dfs(List<String> result, String num, String cmb, long sum, long pre, int target) {
        if (sum == target && num.length() == 0) {
            result.add(cmb);
            return;
        }
        for (int i = 1; i <= num.length(); i++) {
            String str = num.substring(0, i);
            if (str.length() > 1 && str.charAt(0) == '0') {
                break;
            }
            String nextNum = num.substring(i);
            long cur = Long.valueOf(str);
            if (cmb.equals("")) {
                dfs(result, nextNum, str, cur, cur, target);
            } else {
                dfs(result, nextNum, cmb + "+" + str, sum + cur, cur, target);
                dfs(result, nextNum, cmb + "-" + str, sum - cur, -cur, target);
                dfs(result, nextNum, cmb + "*" + str, (sum - pre) + pre * cur, pre * cur, target);
            }
        }
    }

}
