package Y2020.facebook;

import java.util.LinkedList;
import java.util.List;

public class Q0448_Find_All_Numbers_Disappeared_in_an_Array {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int v = Math.abs(nums[i]) - 1;
            if (nums[v] > 0) nums[v] *= -1;
        }
        List<Integer> rslt = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) rslt.add(i + 1);
        }
        return rslt;
    }

}
