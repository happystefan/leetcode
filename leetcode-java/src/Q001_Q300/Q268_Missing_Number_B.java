package Q001_Q300;

/**
 * Created by mingqiangliang on 12/19/17.
 */
public class Q268_Missing_Number_B {

    public int missingNumber(int[] nums) {
        long sum = nums.length*(nums.length+1)/2;
        for (int num : nums) sum -= num;
        return (int)sum;
    }

}
