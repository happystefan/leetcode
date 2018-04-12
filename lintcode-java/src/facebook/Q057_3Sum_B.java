package facebook;

import java.util.*;

public class Q057_3Sum_B {
    // binary search
    public List<List<Integer>> threeSum(int[] numbers) {
        Arrays.sort(numbers);

        LinkedHashSet<List<Integer>> set = new LinkedHashSet<>();
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i+1; j < numbers.length; j++) {
                int kl = j+1, kr = numbers.length-1;
                while (kl <= kr) {
                    int mid = kl+(kr-kl)/2;
                    int sum = numbers[i]+numbers[j]+numbers[mid];
                    if (sum == 0) {
                        set.add(Arrays.asList(numbers[i], numbers[j], numbers[mid]));
                        break;
                    } else if (sum < 0) {
                        kl = mid+1;
                    } else {
                        kr = mid-1;
                    }
                }
            }
        }

        List<List<Integer>> result = new ArrayList<>(set.size());
        result.addAll(set);
        return result;
    }

}
