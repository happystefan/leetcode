package Y2018.linkedin;

public class Q525_Contiguous_Array {

    //  Time Limit Exceeded
    public int findMaxLength(int[] nums) {
        int[] cnt_0 = new int[nums.length + 1];
        int[] cnt_1 = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            if (nums[i - 1] == 0) {
                cnt_0[i] = cnt_0[i - 1] + 1;
                cnt_1[i] = cnt_1[i - 1];
            } else {
                cnt_0[i] = cnt_0[i - 1];
                cnt_1[i] = cnt_1[i - 1] + 1;
            }
        }
        for (int l = nums.length; l > 1; l--) {
            for (int i = 0; i + l < nums.length + 1; i++) {
                if (cnt_0[i + l] - cnt_0[i] == cnt_1[i + l] - cnt_1[i]) {
                    return l;
                }
            }
        }
        return 0;
    }

}
