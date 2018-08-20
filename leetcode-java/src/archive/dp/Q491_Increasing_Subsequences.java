package archive.dp;

import java.util.*;

public class Q491_Increasing_Subsequences {

    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        set.add(new LinkedList<>());
        for (int num : nums) {
            Set<List<Integer>> tset = new HashSet<>(set);
            for (List<Integer> list : tset) {
                if (list.size() == 0) {
                    set.add(new LinkedList<>(Arrays.asList(num)));
                } else if (num >= list.get(list.size()-1)) {
                    List<Integer> nlist = new LinkedList<>(list);
                    nlist.add(num);
                    set.add(nlist);
                }
            }
        }
        List<List<Integer>> result = new LinkedList<>();
        for (List<Integer> list : set) {
            if (list.size() < 2) {
                continue;
            }
            result.add(list);
        }
        return result;
    }

}
