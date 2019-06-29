package Y2018.linkedin;

public class Q268_Missing_Number_B {

    public int missingNumber(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += i + 1;
            sum -= nums[i];
        }
        return sum;
    }

}
