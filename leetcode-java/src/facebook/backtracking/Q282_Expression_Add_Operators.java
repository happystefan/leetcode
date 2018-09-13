package facebook.backtracking;

import java.util.*;

public class Q282_Expression_Add_Operators {

    public List<String> addOperators(String num, int target) {
        List<String> result = new LinkedList<>();
        dfs(result, num, 0, "", 0, 0, target);
        return result;
    }

    private void dfs(List<String> result, String num, int pos, String comb, long sum, long pre, long target) {
        if (pos == num.length()) {
            System.out.printf("%s %d\n", comb, sum);
            if (sum == target) result.add(comb);
            return;
        }
        for (int i = pos+1; i <= num.length(); i++) {
            String str = num.substring(pos, i);
            if (str.length() > 1 && str.charAt(0) == '0') break;
            long cur = Long.valueOf(str);
            if (comb.equals("")) {
                dfs(result, num, i, comb+str, cur, cur, target);
            } else {
                dfs(result, num, i, comb+"+"+str, sum+cur, cur, target);
                dfs(result, num, i, comb+"-"+str, sum-cur, -cur, target);
                dfs(result, num, i, comb+"*"+str, (sum-pre)+pre*cur, pre*cur, target);
            }
        }
    }

}
