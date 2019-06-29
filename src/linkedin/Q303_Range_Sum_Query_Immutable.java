package linkedin;

public class Q303_Range_Sum_Query_Immutable {

    class NumArray {

        int sums[];

        public NumArray(int[] nums) {
            sums = nums;
            for (int i = 1; i < sums.length; i++) {
                sums[i] += sums[i - 1];
            }
        }

        public int sumRange(int i, int j) {
            return sums[j] - (i == 0 ? 0 : sums[i - 1]);
        }
    }

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */

}
