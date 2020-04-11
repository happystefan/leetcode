package Y2020.facebook;

import java.util.HashMap;
import java.util.Map;

public class Q0930_Binary_Subarrays_With_Sum {

    class solution_presum {

        public int numSubarraysWithSum(int[] A, int S) {
            Map<Integer, Integer> map = new HashMap<>();
            map.put(0, 1);
            int sum = 0;
            int rslt = 0;
            for (int num : A) {
                sum += num;
                rslt += map.getOrDefault(sum - S, 0);
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
            return rslt;
        }

    }

    class solution_sliding_window {

        public int numSubarraysWithSum(int[] A, int S) {
            int l = 0, r = 0, cnt = 0;
            int rslt = 0;
            while (r < A.length) {
                cnt += A[r];

                while (l < r && cnt > S) {
                    cnt -= A[l++];
                }
                if (cnt == S) rslt++;
                for (int i = l; cnt == S && i < r && A[i] == 0; i++) {
                    rslt++;
                }
                r++;
            }
            return rslt;
        }

    }

}
