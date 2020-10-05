package Y2020.linkedin.algo_part1;

import java.util.*;

public class Q022_Permutation {

    class Perm<T> implements Permutation<T> {

        @Override
        public Collection<List<T>> generate(Collection<T> values) {
            List<List<T>> rslt = new ArrayList<>();
            if (values.size() <= 1) {
                rslt.add(new LinkedList<>(values));
                return rslt;
            }

            List<T> vals = new ArrayList<T>(values);
            // Only if we want deduplicate
            // Collections.sort(vals);

            dfs(rslt, vals, new LinkedList<>(), new boolean[values.size()]);
            return rslt;
        }

        private void dfs(List<List<T>> rslt, List<T> vals, List<T> comb, boolean[] visited) {
            if (comb.size() == vals.size()) {
                rslt.add(new LinkedList<>(comb));
                return;
            }
            for (int i = 0; i < vals.size(); i++) {
                if (visited[i]) continue;
                comb.add(vals.get(i));
                visited[i] = true;
                dfs(rslt, vals, comb, visited);
                comb.remove(comb.size() - 1);
                visited[i] = false;
                // Only if we want deduplicate
                // if (i + 1 < vals.size() && vals.get(i).equals(i + 1)) i++;
            }
        }
    }

    interface Permutation<T> {
        Collection<List<T>> generate(Collection<T> values);
    }

}


