package linkedin;

import java.util.LinkedList;
import java.util.List;

public class Q442_Find_All_Duplicates_in_an_Array {

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            int num = Math.abs(nums[i]);
            if (nums[num-1] < 0) {
                result.add(num);
            } else {
                nums[num-1] *= -1;
            }
        }
        return result;
    }

}
