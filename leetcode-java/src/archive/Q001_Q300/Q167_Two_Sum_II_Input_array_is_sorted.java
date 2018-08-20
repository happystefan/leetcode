package archive.Q001_Q300;

import java.util.HashMap;
import java.util.Map;

public class Q167_Two_Sum_II_Input_array_is_sorted {

    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (!map.isEmpty() && map.containsKey(target-numbers[i])) {
                return new int[]{map.get(target-numbers[i])+1, i+1};
            }
            map.put(numbers[i], i);
        }
        return null;
    }

}
