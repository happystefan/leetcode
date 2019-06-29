package tree;

public class Q666_Path_Sum_IV {

    public int pathSum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[][] value = new int[20][20];
        int[][] count = new int[20][20];

        for (int i = 0; i < value.length; i++) {
            for (int j = 0; j < value[0].length; j++) {
                value[i][j] = -1;
            }
        }

        for (int num : nums) {
            value[num / 100][(num / 10) % 10] = num % 10;
        }
        for (int num : nums) {
            if (!isLeaf(value, num)) {
                continue;
            }
            int level = num / 100;
            int index = (num / 10) % 10;
            while (level != 0) {
                count[level][index]++;
                index = (index + 1) / 2;
                level--;
            }
        }
        int result = 0;
        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < count[0].length; j++) {
                if (count[i][j] != 0) {
                    result += count[i][j] * value[i][j];
                }
            }
        }
        return result;
    }

    private boolean isLeaf(int[][] mask, int n) {
        int level = n / 100;
        int left = ((n / 10) % 10) * 2 - 1;
        int right = ((n / 10) % 10) * 2;
        return mask[level + 1][left] == -1 && mask[level + 1][right] == -1;
    }

}
