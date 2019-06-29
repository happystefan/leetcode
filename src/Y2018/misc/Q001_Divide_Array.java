package Y2018.misc;

import java.util.*;

class Q001_Divide_Array {
    /**
     * Given an array of integers, and the array itself is zero sum.
     * Divide the array array into as many zero sum parts as possible.
     * <p>
     * Example:
     * <p>
     * Given nums = [1, 2, 3, 0, 0, -1, -5], return [[0], [0], [1 -1], [2, 3 -5]].
     */

    public List<List<Integer>> divide_array(int[] nums) {
        List<Set<Integer>> power_set = new ArrayList<>();
        List<Integer> power_set_sum = new ArrayList<>();
        power_set.add(new HashSet<>());
        power_set_sum.add(0);

        List<Set<Integer>> zero_sum_set = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            int size = power_set.size();
            for (int j = 0; j < size; j++) {
                Set<Integer> set = new HashSet<>(power_set.get(j));
                set.add(i);
                power_set.add(set);
                int sum = power_set_sum.get(j) + nums[i];
                power_set_sum.add(sum);
                if (sum == 0) {
                    zero_sum_set.add(set);
                }
            }
        }

        Collections.sort(zero_sum_set, (a, b) -> Integer.compare(a.size(), b.size()));

        List<List<Integer>> result = new LinkedList<>();
        Set<Integer> removed = new HashSet<>();
        Set<Integer> remaining = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            remaining.add(i);
        }

        while (removed.size() != nums.length) {
            for (Set<Integer> set : zero_sum_set) {
                Set<Integer> intersect = new HashSet<>(set);
                intersect.retainAll(removed);
                if (intersect.size() != 0) {
                    continue;
                }
                removed.addAll(set);
                remaining.removeAll(set);
                List<Integer> list = new LinkedList<>();
                for (int i : set) {
                    list.add(nums[i]);
                }
                result.add(list);
                if (set.size() * 2 > remaining.size()) {
                    list = new LinkedList<>();
                    for (int i : remaining) {
                        list.add(nums[i]);
                    }
                    result.add(list);
                    return result;
                }
            }
        }
        return result;
    }

}
