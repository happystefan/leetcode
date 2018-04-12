package facebook;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Q057_3Sum_C {
    // two pointer
    public List<List<Integer>> threeSum(int[] numbers) {
        Arrays.sort(numbers);
        List<List<Integer>> result = new LinkedList<>();
        for (int i = 0; i < numbers.length; i++) {
            if (i > 0 && numbers[i] == numbers[i-1]) {
                continue;
            }
            int l = i+1, r = numbers.length-1;
            while (l < r) {
                int sum = numbers[i] + numbers[l] + numbers[r];
                if (sum < 0) {
                    l++;
                } else if (sum > 0) {
                    r--;
                } else {
                    result.add(Arrays.asList(numbers[i], numbers[l], numbers[r]));
                    l++;
                    while (l < r && numbers[l] == numbers[l-1]) {
                        l++;
                    }
                }
            }
        }
        return result;
    }
}
