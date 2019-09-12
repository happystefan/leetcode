package Y2019.google;

import java.util.*;

public class Q0465_Optimal_Account_Balancing {

    public int minTransfers(int[][] transactions) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] tran : transactions) {
            int a = tran[0], b = tran[1], c = tran[2];
            map.put(a, map.getOrDefault(a, 0) + c);
            map.put(b, map.getOrDefault(b, 0) - c);
        }
        List<Integer> debts = new ArrayList<>(map.values());
        return dfs(debts, 0);
    }

    private int dfs(List<Integer> debts, int pos) {
        while (pos < debts.size() && debts.get(pos) == 0) pos++;
        if (pos == debts.size()) return 0;
        int result = Integer.MAX_VALUE;
        for (int i = pos + 1; i < debts.size(); i++) {
            if (debts.get(pos) * debts.get(i) < 0) {
                debts.set(i, debts.get(i) + debts.get(pos));
                result = Math.min(result, 1 + dfs(debts, pos + 1));
                debts.set(i, debts.get(i) - debts.get(pos));
            }
        }
        return result;
    }

}
