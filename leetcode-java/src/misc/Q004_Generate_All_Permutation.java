package misc;

import java.util.*;

public class Q004_Generate_All_Permutation {

    /**
     * Write a function that, given a positive n, generate all the permutation of
     * [0, n-1]
     */
    public List<List<Integer>> generateAllPermutation(int n) {
        Set<Integer> nums = new HashSet<>(n);
        for (int i = 0; i < n; i++) {
            nums.add(i);
        }
        List<List<Integer>> result = new LinkedList<>();
        return gen(result, new ArrayList<>(n), nums);
    }

    private List<List<Integer>> gen(List<List<Integer>> result, List<Integer> list, Set<Integer> nums) {
        if (nums.isEmpty()) {
            result.add(new LinkedList<>(list));
        }
        for (int num : nums) {
            list.add(num);
            Set<Integer> remaining = new HashSet<>(nums);
            remaining.remove(num);
            gen(result, list, remaining);
            list.remove(list.size()-1);
        }
        return result;
    }

}

