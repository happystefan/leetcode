package Y2018.google;

import java.util.LinkedList;
import java.util.List;

public class Q448_Find_All_Numbers_Disappeared_in_an_Array {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            int v = Math.abs(nums[i]) - 1;
            if (nums[v] > 0) nums[v] *= -1;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) ans.add(i + 1);
        }
        return ans;
    }

}
