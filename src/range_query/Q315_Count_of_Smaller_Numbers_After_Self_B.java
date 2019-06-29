package range_query;

import java.util.Arrays;
import java.util.List;

public class Q315_Count_of_Smaller_Numbers_After_Self_B {

    // MergeSort
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        Integer[] result = new Integer[n];
        int[][] pairs = new int[n][2]; // pair[0] -- num; pair[1] -- index
        for (int i = 0; i < n; i++) {
            pairs[i] = new int[]{nums[i], i};
        }
        mergeSort(result, pairs, 0, n - 1);
        return Arrays.asList(result);
    }

    private void mergeSort(Integer[] result, int[][] pairs, int l, int r) {
        if (l >= r) {
            return;
        }
        int m = l + (r - l) / 2;
        mergeSort(result, pairs, l, m);
        mergeSort(result, pairs, m + 1, r);
        int[][] left = Arrays.copyOfRange(pairs, l, m + 1);
        int[][] right = Arrays.copyOfRange(pairs, m + 1, r + 1);
        for (int k = l, i = 0, j = 0; k <= r; k++) {
            if (j >= right.length || (i < left.length && left[i][0] <= right[j][0])) {
                result[left[i][1]] += j;
                pairs[k] = left[i++];
            } else {
                pairs[k] = right[j++];
            }
        }
    }

}
