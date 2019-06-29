package linkedin;

public class Q307_Range_Sum_Query_Mutable {

    // Binary Index Tree
    class NumArray {

        int[] nums;
        int[] sums;

        public NumArray(int[] nums) {
            this.nums = new int[nums.length];
            sums = new int[nums.length + 1];
            for (int i = 0; i < nums.length; i++) {
                update(i, nums[i]);
            }
        }

        public void update(int i, int val) {
            int diff = val - nums[i];
            nums[i] = val;
            i += 1;
            while (i <= nums.length) {
                sums[i] += diff;
                i += i & (-i);
            }
        }

        private int query(int i) {
            i += 1;
            int result = 0;
            while (i != 0) {
                result += sums[i];
                i -= i & (-i);
            }
            return result;
        }

        public int sumRange(int i, int j) {
            return query(j) - query(i - 1);
        }

    }

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */

}
