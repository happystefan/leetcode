package backtracking;

import java.util.LinkedList;
import java.util.List;

public class Q078_Subsets_B {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        result.add(new LinkedList<>());
        for (int num : nums) {
            List<List<Integer>> tmp = new LinkedList<>(result);
            for (List<Integer> list : tmp) {
                list.add(num);
                result.add(new LinkedList<>(list));
                list.remove(list.size() - 1);
            }
        }
        return result;
    }

}
