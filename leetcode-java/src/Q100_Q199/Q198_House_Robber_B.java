package Q100_Q199;

public class Q198_House_Robber_B {

    public int rob(int[] nums) {
        int include = 0, exclude = 0;
        for(int num : nums) {
            int in = include, ex = exclude;
            include = ex+num;
            exclude = Math.max(in, ex);
        }
        return Math.max(include, exclude);
    }
}
