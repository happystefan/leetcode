package Y2020.linkedin.algo_part1;

import java.util.LinkedList;
import java.util.List;

public class Q035_Print_Factors {

    public List<String> printFactors(int n) {
        List<String> rslt = new LinkedList<>();
        dfs(rslt, new LinkedList<>(), 2, n);
        return rslt;
    }

    private void dfs(List<String> rslt, List<String> factors, int start, int n) {
        if (n == 1) {
            if (factors.size() == 1) factors.add(String.valueOf(1));
            rslt.add(String.join("*", factors));
            return;
        }
        for (int i = start; i <= n; i++) {
            if (n % i != 0) continue;
            factors.add(String.valueOf(i));
            dfs(rslt, factors, i, n / i);
            factors.remove(factors.size() - 1);
        }
    }

}
