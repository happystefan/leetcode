package Q200_Q299;

import java.util.LinkedList;
import java.util.List;

public class Q216_Combination_Sum_III {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new LinkedList<>();
        bfs(ans, new LinkedList<>(), k, 1, n);
        return ans;
    }

    public void bfs(List<List<Integer>> ans,List<Integer> comb, int k, int start, int n){
        if (comb.size() == k && n == 0) {
            ans.add(new LinkedList<>(comb));
            return;
        }
        for (int i = start; i <= 9; i++) {
            List<Integer> ncomb = new LinkedList<>(comb);
            ncomb.add(i);
            bfs(ans, ncomb, k, i+1, n-i);
        }
    }

}
