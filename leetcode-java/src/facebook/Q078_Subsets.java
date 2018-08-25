package facebook;

import java.util.*;

public class Q078_Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        result.add(new LinkedList<>());
        for (int num : nums) {
            List<List<Integer>> tmp = new LinkedList<>(result);
            for (List<Integer> list : result) {
                list.add(num);
                tmp.add(new LinkedList<>(list));
                list.remove(list.size()-1);
            }
            result = tmp;
        }
        return result;
    }

}
