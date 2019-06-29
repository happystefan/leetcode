package facebook;

public class Q360_Sort_Transformed_Array {

    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int n = nums.length;
        int[] result = new int[n];
        int idx = a >= 0 ? n - 1 : 0;
        int i = 0, j = n - 1;
        while (i <= j) {
            int num1 = cal(nums[i], a, b, c);
            int num2 = cal(nums[j], a, b, c);
            if (a >= 0) {
                result[idx--] = Math.max(num1, num2);
                if (num1 > num2) {
                    i++;
                } else {
                    j--;
                }
            } else {
                result[idx++] = Math.min(num1, num2);
                if (num1 < num2) {
                    i++;
                } else {
                    j--;
                }
            }
        }
        return result;
    }

    private int cal(int num, int a, int b, int c) {
        return a * num * num + b * num + c;
    }

}
