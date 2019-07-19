package Y2019.Q0001_Q0300;

public class Q0070_Climbing_Stairs {

    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        int one_step_before = 2;
        int two_step_before = 1;
        int all_ways = 0;
        for (int i = 2; i < n; i++) {
            all_ways = one_step_before + two_step_before;
            two_step_before = one_step_before;
            one_step_before = all_ways;
        }
        return all_ways;
    }

}
