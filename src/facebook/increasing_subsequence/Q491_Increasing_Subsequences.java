package facebook.increasing_subsequence;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Q491_Increasing_Subsequences {

    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        set.add(new LinkedList<>());
        for (int num : nums) {
            Set<List<Integer>> new_set = new HashSet<>(set);
            for (List<Integer> list : set) {
                if (list.isEmpty() || num >= list.get(list.size() - 1)) {
                    List<Integer> new_list = new LinkedList<>(list);
                    new_list.add(num);
                    new_set.add(new_list);
                }
            }
            set = new_set;
        }
        List<List<Integer>> result = new LinkedList<>();
        for (List<Integer> list : set) {
            if (list.size() >= 2) result.add(list);
        }
        return result;
    }

}
