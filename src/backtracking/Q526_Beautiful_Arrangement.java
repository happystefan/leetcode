package backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q526_Beautiful_Arrangement {

    //  Time Limit Exceeded

    int result = 0;

    public int countArrangement(int N) {
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= N; i++) {
            set.add(i);
        }
        dfs(new ArrayList<>(N), set);
        return result;
    }

    private void dfs(List<Integer> list, Set<Integer> set) {
        if (set.isEmpty()) {
            if (isBeautiful(list)) {
                result++;
            }
            return;
        }
        for (int num : set) {
            Set<Integer> new_set = new HashSet<>(set);
            new_set.remove(num);
            list.add(num);
            dfs(list, new_set);
            list.remove(num);
        }
    }

    private boolean isBeautiful(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % i != 0 && i % (list.get(i)) != 0) {
                return false;
            }
        }
        return true;
    }

}
