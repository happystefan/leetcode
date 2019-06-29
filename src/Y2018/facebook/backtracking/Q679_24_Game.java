package Y2018.facebook.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Q679_24_Game {

    double eps = 1e-6;

    public boolean judgePoint24(int[] nums) {
        List<Double> list = new ArrayList<>();
        for (int num : nums) list.add((double) num);
        return dfs(list);
    }

    private boolean dfs(List<Double> nums) {
        if (nums.size() == 1) {
            return Math.abs(nums.get(0) - 24) < eps;
        }
        int n = nums.size();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double a = nums.get(i), b = nums.get(j);
                nums.remove(j);
                nums.remove(i);
                List<Double> next = new ArrayList<>();
                next.add(a + b);
                next.add(a - b);
                next.add(b - a);
                next.add(a * b);
                if (Math.abs(b) > eps) next.add(a / b);
                if (Math.abs(a) > eps) next.add(b / a);
                for (double num : next) {
                    nums.add(num);
                    if (dfs(nums)) return true;
                    nums.remove(nums.size() - 1);
                }
                nums.add(i, a);
                nums.add(j, b);
            }
        }
        return false;
    }

}
