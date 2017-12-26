package google;

import java.util.*;

/**
 * Created by mingqiangliang on 12/26/17.
 */
public class Q707_Balance_Graph {

    public int balanceGraph(int[][] edges) {
        // Write your code here
        Map<Integer, Integer> balance = new HashMap<>();
        for (int[] edge : edges) {
            balance.put(edge[0], balance.getOrDefault(edge[0], 0)-edge[2]);
            balance.put(edge[1], balance.getOrDefault(edge[1] ,0)+edge[2]);
        }
        List<Integer> debt = new ArrayList<>();
        for (int i : balance.values()) {
            if (i != 0) debt.add(i);
        }

        int ans = 0;
        int len = 2;
        while (debt.size() != 0) {
            // try to find a set of length = targetLen which sum to 0
            List<Integer> indexes = new ArrayList<>();
            boolean found = Find(debt, indexes, len, 0, 0);
            if (found) {
                // because this is the minimum length set that can sum to zero,
                // this set will require (len - 1) transactions to balance
                ans += indexes.size() - 1;
                // remove these values from the list and try again for another set of this length
                int indexesIndex = 0;
                List<Integer> next = new ArrayList<>();
                for (int i = 0; i < debt.size(); i++) {
                    if (indexesIndex < indexes.size() && i == indexes.get(indexesIndex)) indexesIndex++;
                    else next.add(debt.get(i));
                }
                debt = next;
            } else {
                // no set of this length was found, try the next length
                len++;
            }
        }
        return ans;

    }

    // DFS - find targetLen amount of items that sum to zero
    // store the indexes of these elements
    public boolean Find(List<Integer> debt, List<Integer> indexes, int len, int sum, int start) {
        if (indexes.size() == len) return sum == 0;
        for (int i = start; i < debt.size(); i++) {
            indexes.add(i);
            if (Find(debt, indexes, len, sum+debt.get(i), i+1)) {
                return true;
            }
            indexes.remove(indexes.size()-1);
        }
        return false;
    }

}
