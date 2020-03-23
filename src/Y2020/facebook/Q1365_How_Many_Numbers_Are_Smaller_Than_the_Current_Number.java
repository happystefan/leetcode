package Y2020.facebook;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Q1365_How_Many_Numbers_Are_Smaller_Than_the_Current_Number {

    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] copy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copy);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < copy.length; i++) {
            map.putIfAbsent(copy[i], i);
        }
        int[] rslt = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            rslt[i] = map.get(nums[i]);
        }
        return rslt;
    }

}
