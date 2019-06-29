package Y2018.Q001_Q300;

public class Q136_Single_Number {

    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int n : nums) {
            ans ^= n;
        }
        return ans;
    }

}
