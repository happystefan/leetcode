package archive.linkedin;

import java.util.*;

public class Q018_4Sum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Map<Integer, Set<int[]>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                map.computeIfAbsent(nums[i]+nums[j], k->new HashSet<>());
                map.get(nums[i]+nums[j]).add(new int[]{i, j});
            }
        }
        Set<List<Integer>> quadruplets = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (!map.containsKey(target-nums[i]-nums[j])) {
                    continue;
                }
                for (int[] mn : map.get(target-nums[i]-nums[j])) {
                    int m = mn[0], n = mn[1];
                    if (m > j) {
                        List<Integer> quadruplet = Arrays.asList(nums[i], nums[j], nums[m], nums[n]);
                        Collections.sort(quadruplet);
                        quadruplets.add(quadruplet);
                    }
                }
            }
        }
        List<List<Integer>> result = new LinkedList<>();
        result.addAll(quadruplets);
        return result;
    }

}
