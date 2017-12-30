package google;

import java.util.ArrayList;
import java.util.List;

public class Q279_Perfect_Squares_B {

    public int numSquares(int n) {
        List<Integer> dp = new ArrayList<>();
        dp.add(0);
        while (dp.size() <= n) {
            int m = dp.size();
            int next = Integer.MAX_VALUE;
            for (int i = 1; i*i <= m; i++) {
                next = Math.min(next, dp.get(m-i*i)+1);
            }
            dp.add(next);
        }
        return dp.get(n);
    }

}
