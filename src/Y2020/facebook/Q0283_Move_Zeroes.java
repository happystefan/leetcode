package Y2020.facebook;

public class Q0283_Move_Zeroes {

    class solution_overwrite {

        public void moveZeroes(int[] nums) {
            if (nums == null || nums.length == 0) return;
            int i = 0;
            for (int num : nums) {
                if (num == 0) continue;
                nums[i++] = num;
            }
            while (i < nums.length) nums[i] = 0;
        }

    }

    class solution_swap {

        public void moveZeroes(int[] nums) {
            if (nums == null || nums.length == 0) return;
            int i = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] != 0) swap(nums, i++, j);
            }
        }

        private void swap(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }

    }

}
