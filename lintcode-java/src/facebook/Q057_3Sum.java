package facebook;

import java.util.*;

public class Q057_3Sum {
    // hashmap
    public List<List<Integer>> threeSum(int[] numbers) {
        Arrays.sort(numbers);

        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i+1; j < numbers.length; j++) {
                map.computeIfAbsent(numbers[i]+numbers[j], k -> new LinkedList<>());
                map.get(numbers[i]+numbers[j]).add(new int[]{i, j});
            }
        }

        LinkedHashSet<List<Integer>> set = new LinkedHashSet<>();
        for (int k = 0; k < numbers.length; k++) {
            if (map.containsKey(-numbers[k])) {
                List<int[]> indices = map.get(-numbers[k]);
                for (int[] indice : indices) {
                    int i = indice[0], j = indice[1];
                    if (k < i) {
                        set.add(Arrays.asList(numbers[k], numbers[i], numbers[j]));
                    }
                }
            }
        }

        List<List<Integer>> result = new ArrayList<>(set.size());
        result.addAll(set);
        return result;
    }

}