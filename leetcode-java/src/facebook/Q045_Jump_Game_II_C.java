package facebook;

public class Q045_Jump_Game_II_C {

    public int jump(int[] nums) {
        int result = 0;
        int l = 0, r = 0;
        while (r < nums.length-1) {
            int ll = r;
            int rr = r;
            for (int i = l; i <= r; i++) {
                rr = Math.max(rr, i+nums[i]);
            }
            l = ll;
            r = rr;
            result++;
        }
        return result;
    }

}
