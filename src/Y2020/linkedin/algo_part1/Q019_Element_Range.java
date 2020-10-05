package Y2020.linkedin.algo_part1;

public class Q019_Element_Range {

    public int[] range(int[] nums, int target) {
        if (nums == null || nums.length == 0) return null;
        return new int[]{find_first(nums, target), find_last(nums, target)};
    }

    private int find_first(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = l + (r - l) /2;
            if (nums[m] < target) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return nums[l] == target ? l : -1; // !!!!!!!!!!!!!!!!
    }

    private int find_last(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = r - (r - l) /2;
            if (nums[m] > target) {
                r = m - 1;
            } else {
                l = m;
            }
        }
        return nums[l] == target ? l : -1; // !!!!!!!!!!!!!!!!
    }

}
