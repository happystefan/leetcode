package google;

import java.util.*;

/**
 * Created by mingqiangliang on 12/24/17.
 */
public class Q717_Tree_Longest_Path_With_Same_Value {

    public int LongestPathWithSameValue(int[] A, int[] E) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            map.put(i+1, new LinkedList<>());
        }
        for (int i = 0; i < A.length-1; i++) {
            map.get(E[i*2]).add(E[i*2+1]);
            map.get(E[i*2+1]).add(E[i*2]);
        }
        int[] ans = new int[1];
        dfs(1, 0, A, map, ans);
        return ans[0]-1;
    }

    public int dfs(int index, int parent, int[] A, Map<Integer, List<Integer>> map, int[] ans) {
        List<Integer> v = new ArrayList<>();
        for (int son: map.get(index)) {
            if (son != parent) {
                if (A[son - 1] == A[index - 1]) v.add(dfs(son, index, A, map, ans));
                else dfs(son, index, A, map, ans);
            }
        }
        v.add(0);
        v.add(0);
        Collections.sort(v);
        Collections.reverse(v);
        ans[0] = Math.max(ans[0],v.get(0)+v.get(1)+1);
        return v.get(0)+1;
    }

}