package archive.linkedin;

import java.util.LinkedList;
import java.util.List;

public class Q448_Find_All_Numbers_Disappeared_in_an_Array {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            int num = Math.abs(nums[i]);
            nums[num-1] = -Math.abs(nums[num-1]);
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i+1);
            }
        }
        return result;
    }

}
