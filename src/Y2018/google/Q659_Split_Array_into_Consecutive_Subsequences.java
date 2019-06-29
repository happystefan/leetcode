package Y2018.google;

import java.util.HashMap;
import java.util.Map;

public class Q659_Split_Array_into_Consecutive_Subsequences {

    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> cntMap = new HashMap<>();
        Map<Integer, Integer> seqMap = new HashMap<>();
        for (int num : nums) {
            cntMap.put(num, cntMap.getOrDefault(num, 0) + 1);
        }
        for (int num : nums) {
            if (cntMap.get(num) == 0) {
                continue;
            }
            /*
            This is wrong:
                * first check whether nums[i] can create a new subsequence; if not, then check whether it can extend existing subsequences.
            Counter example: [1 2 3 4 5 5 6 7]
                * If create a new subsequence first, will get [1 2 3] then [4 5 6] then return false.
                * But actually the answer is true because we can split the array by 1 2 3 4 5 and 5 6 7.
            */
            if (seqMap.getOrDefault(num, 0) > 0) {
                seqMap.put(num, seqMap.get(num) - 1);
                seqMap.put(num + 1, seqMap.getOrDefault(num + 1, 0) + 1);
            } else if (cntMap.getOrDefault(num + 1, 0) > 0 && cntMap.getOrDefault(num + 2, 0) > 0) {
                cntMap.put(num + 1, cntMap.get(num + 1) - 1);
                cntMap.put(num + 2, cntMap.get(num + 2) - 1);
                seqMap.put(num + 3, seqMap.getOrDefault(num + 3, 0) + 1);
            } else {
                return false;
            }
            cntMap.put(num, cntMap.get(num) - 1);
        }
        return true;
    }

}
