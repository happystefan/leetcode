package google;

import java.util.LinkedList;
import java.util.List;

public class Q653_Add_Operators {

    public List<String> addOperators(String num, int target) {
        // write your code here
        List<String> ans = new LinkedList<>();
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
            long cur = Long.parseLong(str);
            if (comb.length() == 0) {
                dfs(nnum, target, str, cur, cur, ans);
            } else {
                dfs(nnum, target, comb+"+"+str, res+cur, cur, ans);
                dfs(nnum, target, comb+"-"+str, res-cur, -cur, ans);
                dfs(nnum, target, comb+"*"+str, res-pre+pre*cur, pre*cur, ans);
            }
        }
    }

}
