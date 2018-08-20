package archive.bfs_dfs;

import java.util.*;

public class Q638_Shopping_Offers {

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        return dfs(price, special, needs, 0);
    }

    public int dfs(List<Integer> price, List<List<Integer>> special, List<Integer> needs, int pos) {
        int result = 0;
        for (int i = 0; i < needs.size(); i++) {
            result += price.get(i)*needs.get(i);
        }
        for (int i = pos; i < special.size(); i++) {
            List<Integer> sp = special.get(i);
            List<Integer> new_needs = new ArrayList<>(needs.size());
            boolean isValid = true;
            for (int j = 0; j < needs.size(); j++) {
                new_needs.add(needs.get(j)-sp.get(j));
                if (new_needs.get(j) < 0) {
                    isValid = false;
                    break;
                }
            }
            if (!isValid) {
                continue;
            }
            result = Math.min(result, sp.get(sp.size()-1)+dfs(price, special, new_needs, i));
        }
        return result;
    }

}
