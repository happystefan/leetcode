package Y2020.facebook;

import java.util.Arrays;

public class Q0666_Path_Sum_IV {

    public int pathSum(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[][] val = new int[10][10];
        int[][] cnt = new int[10][10];
        for (int i = 0; i < val.length; i++) {
            Arrays.fill(val[i], -1);
        }
        for (int num : nums) {
            val[num / 100][(num / 10) % 10] = num % 10;
        }
        for (int num : nums) {
            int level = num / 100, idx = (num / 10) % 10;
            if (!isLeaf(level, idx, val)) continue;
            while (level != 0) {
                cnt[level][idx]++;
                idx = (idx + 1) / 2;
                level--;
            }
        }
        int rslt = 0;
        for (int i = 0; i < cnt.length; i++) {
            for (int j = 0; j < cnt[0].length; j++) {
                rslt += val[i][j] * cnt[i][j];
            }
        }
        return rslt;
    }

    private boolean isLeaf(int level, int idx, int[][] val) {
        int left = idx * 2 - 1, right = idx * 2;
        return val[level + 1][left] == -1 && val[level + 1][right] == -1;
    }

}
