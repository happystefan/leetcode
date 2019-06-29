package Y2018.bfs_dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q638_Shopping_Offers_B {

    Map<List<Integer>, Integer> memo = new HashMap<>();

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        return dfs(price, special, needs);
    }

    public int dfs(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        if (memo.containsKey(needs)) {
            return memo.get(needs);
        }
        int result = 0;
        for (int i = 0; i < needs.size(); i++) {
            result += price.get(i) * needs.get(i);
        }
        for (List<Integer> sp : special) {
            List<Integer> new_needs = new ArrayList<>(needs.size());
            boolean isValid = true;
            for (int j = 0; j < needs.size(); j++) {
                new_needs.add(needs.get(j) - sp.get(j));
                if (new_needs.get(j) < 0) {
                    isValid = false;
                    break;
                }
            }
            if (!isValid) {
                continue;
            }
            result = Math.min(result, sp.get(sp.size() - 1) + dfs(price, special, new_needs));
        }
        memo.put(needs, result);
        return result;
    }

}
