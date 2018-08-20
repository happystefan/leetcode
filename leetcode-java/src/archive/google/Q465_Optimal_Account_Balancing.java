package archive.google;

import java.util.*;

public class Q465_Optimal_Account_Balancing {

    public int minTransfers(int[][] transactions) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] t : transactions) {
            int a = t[0], b = t[1], v = t[2];
            map.put(a, map.getOrDefault(a, 0)-v);
            map.put(b, map.getOrDefault(b, 0)+v);
        }
        List<Integer> debt = new ArrayList<>(map.values());
        return dfs(debt, 0);
    }

    private int dfs(List<Integer> debt, int pos) {
        while (pos < debt.size() && debt.get(pos) == 0) {
            pos++;
        }
        if (pos == debt.size()) {
            return 0;
        }
        int result = Integer.MAX_VALUE;
        for (int i = pos+1; i < debt.size(); i++) {
            if (debt.get(pos)*debt.get(i) < 0) {
                debt.set(i, debt.get(i)+debt.get(pos));
                result = Math.min(result, 1+dfs(debt, pos+1));
                debt.set(i, debt.get(i)-debt.get(pos));
            }
        }
        return result;
    }

}
