package linkedin;

import java.util.*;

public class Q015_3sum {

    public List<List<Integer>> threeSum(int[] nums) {
        Map<Integer, Set<int[]>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                map.computeIfAbsent(nums[i] + nums[j], k -> new HashSet<>());
                map.get(nums[i] + nums[j]).add(new int[]{i, j});
            }
        }
        Set<List<Integer>> triples = new HashSet<>();
        for (int k = 0; k < nums.length; k++) {
            if (map.containsKey(-nums[k])) {
                for (int[] ij : map.get(-nums[k])) {
                    int i = ij[0], j = ij[1];
                    if (k > i && k > j) {
                        int[] triple = new int[]{nums[i], nums[j], nums[k]};
                        Arrays.sort(triple);
                        triples.add(Arrays.asList(triple[0], triple[1], triple[2]));
                    }
                }
            }
        }

        List<List<Integer>> result = new LinkedList<>();
        result.addAll(triples);
        return result;
    }

}
