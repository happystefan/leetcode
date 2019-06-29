package backtracking;

import java.util.HashSet;
import java.util.Set;

public class Q526_Beautiful_Arrangement_B {

    int result = 0;

    public int countArrangement(int N) {
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= N; i++) {
            set.add(i);
        }
        dfs(1, set);
        return result;
    }

    private void dfs(int idx, Set<Integer> set) {
        if (set.size() == 0) {
            result++;
            return;
        }
        for (int num : set) {
            if (num % idx == 0 || idx % num == 0) {
                Set<Integer> new_set = new HashSet<>(set);
                new_set.remove(num);
                dfs(idx + 1, new_set);
            }
        }
    }

}
