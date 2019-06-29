package bfs_dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q679_24_Game {
    private double eps = 1e-6;

    public boolean judgePoint24(int[] nums) {
        List<Double> list = new ArrayList<>(nums.length);
        for (int num : nums) {
            list.add((double) num);
        }
        return dfs(list);
    }

    private boolean dfs(List<Double> nums) {
        int n = nums.size();
        if (n == 1) {
            return Math.abs(nums.get(0) - 24.0) < eps;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double a = nums.get(i);
                double b = nums.get(j);
                nums.remove(j);
                nums.remove(i);
                List<Double> next = new LinkedList<>();
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
