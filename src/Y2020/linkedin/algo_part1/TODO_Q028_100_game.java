package Y2020.linkedin.algo_part1;

import java.util.*;

public class TODO_Q028_100_game {

    // without memo: num of permutation which lead to the desire sum, O(N*N!)
    // with memo: num combination which lead to the desire sum, O(N*2^N)
    // String state = Arrays.toString(used); this contains a for loop, which spend O(N)
    class solution_cannot_resue_num {

        public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
            if (maxChoosableInteger < 0) {
                return false;
            }
            if (maxChoosableInteger * (maxChoosableInteger + 1) / 2 < desiredTotal) {
                return false;
            }
            boolean[] used = new boolean[maxChoosableInteger + 1];
            Map<String, Boolean> memo = new HashMap<>();
            return canIWin(memo, 0, desiredTotal, used);
        }

        private boolean canIWin(Map<String, Boolean> memo, int current, int desire, boolean[] used) {
            if (current >= desire) return true;
            String state = Arrays.toString(used);
            if (memo.containsKey(state)) return memo.get(state);
            boolean rslt = false;
            // for (int i = 1; i < used.length; i++) {
            // heuristic improvement -- use large num first
            for (int i = used.length - 1; i >= 1; i--) {
                if (used[i]) continue;
                used[i] = true;
                if (current + i >= desire || !canIWin(memo, current + i, desire, used)) {
                    rslt = true;
                    break;
                }
                used[i] = false;
            }
            memo.put(state, rslt);
            return rslt;
        }

    }

}
