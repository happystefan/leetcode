package Y2018.Q001_Q300;

/**
 * Created by mingqiangliang on 12/19/17.
 */
public class Q268_Missing_Number_C {

    public int missingNumber(int[] nums) {
        int ans = nums.length;
        for (int i = 0; i < nums.length; i++) {
            ans ^= i;
            ans ^= nums[i];
        }
        return ans;
    }

}
