package Y2018.facebook;

public class Q485_Max_Consecutive_Ones {

    public int findMaxConsecutiveOnes(int[] nums) {
        int result = 0;
        int l = 0, r = 0;
        while (r < nums.length) {
            while (r < nums.length && nums[r] != 1) r++;
            l = r;
            while (r < nums.length && nums[r] == 1) r++;
            result = Math.max(result, r - l);
        }
        return result;
    }

}
