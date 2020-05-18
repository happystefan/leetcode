package Y2020.facebook.misc;

import java.util.Arrays;
import java.util.TreeSet;

public class Q1099_Two_Sum_Less_Than_K {

    class solution_treeset {

        public int twoSumLessThanK(int[] A, int K) {
            TreeSet<Integer> set = new TreeSet<>();
            int rslt = Integer.MIN_VALUE;
            for (int num : A) {
                Integer lower = set.lower(K - num);
                set.add(num);
                if (lower != null) rslt = Math.max(rslt, lower + num);
            }
            return rslt == Integer.MIN_VALUE ? -1 : rslt;
        }

    }

    class solution_two_pointer {

        public int twoSumLessThanK(int[] A, int K) {
            Arrays.sort(A);
            int rslt = Integer.MIN_VALUE;
            int l = 0, r = A.length - 1;
            while (l < r) {
                int sum = A[l] + A[r];
                if (sum < K) {
                    rslt = Math.max(rslt, sum);
                    l++;
                } else {
                    r--;
                }
            }
            return rslt == Integer.MIN_VALUE ? -1 : rslt;
        }

    }

}
