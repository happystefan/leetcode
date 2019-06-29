package Y2018.google;

import java.util.Stack;

public class Q321_Create_Maximum_Number_C {

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int m = nums1.length, n = nums2.length;
        int[] result = new int[k];
        for (int i = Math.max(0, k - n); i <= Math.min(k, m); i++) {
            result = max(result, 0, merge(maxArray(nums1, i), maxArray(nums2, k - i)), 0);
        }
        return result;
    }

    private int[] merge(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int[] result = new int[m + n];
        int i = 0, j = 0, k = 0;
        while (i < m || j < n) {
            result[k++] = max(nums1, i, nums2, j) == nums1 ? nums1[i++] : nums2[j++];
        }
        return result;
    }

    private int[] maxArray(int[] nums, int k) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            while (!stack.isEmpty() && stack.peek() < num && stack.size() + nums.length - 1 - i >= k) {
                stack.pop();
            }
            stack.push(num);
        }
        while (stack.size() > k) {
            stack.pop();
        }
        int[] result = new int[k];
        while (!stack.isEmpty()) {
            result[--k] = stack.pop();
        }
        return result;
    }

    private int[] max(int[] nums1, int i, int[] nums2, int j) {
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] > nums2[j]) {
                return nums1;
            }
            if (nums1[i] < nums2[j]) {
                return nums2;
            }
            i++;
            j++;
        }
        return i == nums1.length ? nums2 : nums1;
    }

}
