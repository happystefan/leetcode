package Y2020.facebook;

import java.util.LinkedList;
import java.util.List;

public class Q0442_Find_All_Duplicates_in_an_Array {

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> rslt = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            int v = Math.abs(nums[i]) - 1;
            if (nums[v] < 0) rslt.add(v + 1);
            nums[v] *= -1;
        }
        return rslt;
    }

}
