package archive.divide_and_conquer;

import java.util.*;

public class Q315_Count_of_Smaller_Numbers_After_Self_B {

    // Binary Search
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> result = new ArrayList<>(nums.length);
        List<Integer> list = new ArrayList<>(nums.length);
        for (int i = nums.length-1; i>= 0; i--) {
            int idx = Collections.binarySearch(list, nums[i]);
            if (idx >= 0) {
                // found; java archive.binary_search does not guarantee
                // which element will been return if the list contains
                // multiple elements equal to the specified object
                while (idx-1 < nums.length && list.get(idx-1) == nums[i]) {
                    idx--;
                }
            } else { // noyt found, return (-insert_idx)-1
                idx = -idx-1;
            }
            result.add(0, idx);
            list.add(idx, nums[i]);
        }
        return result;
    }

}
