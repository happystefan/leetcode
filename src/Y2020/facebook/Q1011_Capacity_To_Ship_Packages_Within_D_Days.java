package Y2020.facebook;

import java.util.Arrays;

public class Q1011_Capacity_To_Ship_Packages_Within_D_Days {

    public int shipWithinDays(int[] weights, int D) {
        int l = Arrays.stream(weights).max().getAsInt(), r = Arrays.stream(weights).sum();
        while (l < r) {
            int m = l + (r - l) / 2;
            if (!canShip(weights, m, D)) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;
    }

    private boolean canShip(int[] weights, int cap, int D) {
        int cnt = 1;
        int sum = 0;
        for (int w : weights) {
            if (sum + w > cap) {
                cnt++;
                sum = w;
            } else {
                sum += w;
            }
        }
        return cnt <= D;
    }

}
