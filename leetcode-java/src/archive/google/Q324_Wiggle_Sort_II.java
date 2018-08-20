package archive.google;

import java.util.Arrays;

public class Q324_Wiggle_Sort_II {

    public void wiggleSort(int[] nums) {
        int[] sorted = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sorted);

        for (int i = nums.length-1, j = 0, k = i/2+1; i >= 0; i--) {
            nums[i] = i%2 == 1 ?sorted[k++] : sorted[j++];
        }

        return;
    }

}
