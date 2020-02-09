package Y2019.Q0301_Q0600;

public class Q0330_Patching_Array {

    public int minPatches(int[] nums, int n) {
        long miss = 1;
        int cnt = 0, i = 0;
        while (miss <= n) {
            if (i < nums.length && nums[i] <= miss) {
                miss += nums[i++];
            } else {
                cnt++;
                miss += miss;
            }
        }
        return cnt;
    }

}
