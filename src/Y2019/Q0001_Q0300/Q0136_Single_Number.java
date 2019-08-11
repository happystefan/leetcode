package Y2019.Q0001_Q0300;

public class Q0136_Single_Number {

    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }

}
