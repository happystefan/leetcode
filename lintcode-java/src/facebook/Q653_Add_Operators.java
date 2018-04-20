package facebook;

import java.util.LinkedList;
import java.util.List;

public class Q653_Add_Operators {

    public List<String> addOperators(String num, int target) {
        List<String> result = new LinkedList<>();
        dfs(result, num, target, "", 0, 0);
        return result;
    }

    private void dfs(List<String> result, String num, int target, String comb, long cur, long pre) {
        if (num.length() == 0 && target == cur) {
            result.add(comb);
            return;
        }
        for (int i = 1; i <= num.length(); i++) {
            String str = num.substring(0, i);
            if (str.length() > 1 && str.startsWith("0")) {
                return;
            }
            long val = Long.valueOf(str);
            String next_num = num.substring(i);
            if (comb.length() == 0) {
                dfs(result, next_num, target, str, val, val);
            } else {
                dfs(result, next_num, target, comb+"+"+str, cur+val, val);
                dfs(result, next_num, target, comb+"-"+str, cur-val, -val);
                dfs(result, next_num, target, comb+"*"+str, cur-pre+pre*val, pre*val);
            }
        }
    }

}
