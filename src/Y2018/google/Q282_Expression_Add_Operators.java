package Y2018.google;

import java.util.LinkedList;
import java.util.List;

public class Q282_Expression_Add_Operators {

    public List<String> addOperators(String num, int target) {
        List<String> ans = new LinkedList<>();
        if (num == null || num.length() == 0) return ans;
        dfs(num, target, "", 0, 0, ans);
        return ans;
    }

    private void dfs(String num, int target, String comb, long res, long pre, List<String> ans) {
        if (res == target && num.length() == 0) {
            ans.add(comb);
            return;
        }
        for (int i = 1; i <= num.length(); i++) {
            String str = num.substring(0, i);
            if (str.length() > 1 && str.startsWith("0")) return;

            String nnum = num.substring(i);
            long cur = Long.valueOf(str);
            if (comb.equals("")) {
                dfs(nnum, target, str, cur, cur, ans);
            } else {
                dfs(nnum, target, comb + "+" + str, res + cur, cur, ans);
                dfs(nnum, target, comb + "-" + str, res - cur, -cur, ans);
                dfs(nnum, target, comb + "*" + str, res - pre + pre * cur, pre * cur, ans);
            }
        }
    }

}
