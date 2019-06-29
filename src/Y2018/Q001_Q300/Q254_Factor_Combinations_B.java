package Y2018.Q001_Q300;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by mingqiangliang on 12/18/17.
 */
public class Q254_Factor_Combinations_B {

    public List<List<Integer>> getFactors(int n) {
        return getFactors(2, n, true);
    }

    public List<List<Integer>> getFactors(int start, int n, boolean isFirstCall) {
        List<List<Integer>> ans = new LinkedList<>();
        if (!isFirstCall) ans.add(Arrays.asList(n));

        for (int i = start; i * i <= n; i++) {
            if (n % i != 0) {
                continue;
            }
            List<List<Integer>> subcom = getFactors(i, n / i, false);
            for (List<Integer> com : subcom) {
                List<Integer> sub = new LinkedList<>(com);
                sub.add(i);
                ans.add(sub);
            }
        }
        return ans;
    }

}
