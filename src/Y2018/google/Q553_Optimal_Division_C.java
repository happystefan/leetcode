package Y2018.google;

public class Q553_Optimal_Division_C {

    public String optimalDivision(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }
        if (nums.length == 1) {
            return String.valueOf(nums[0]);
        }
        if (nums.length == 2) {
            return String.format("%d/%d", nums[0], nums[1]);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(nums[0]);
        sb.append("/");
        sb.append("(");
        sb.append(nums[1]);
        for (int i = 2; i < nums.length; i++) {
            sb.append("/");
            sb.append(nums[i]);
        }
        sb.append(")");
        return sb.toString();
    }

}
