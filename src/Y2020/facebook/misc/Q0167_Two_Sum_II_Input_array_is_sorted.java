package Y2020.facebook.misc;

public class Q0167_Two_Sum_II_Input_array_is_sorted {

    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0) return null;
        int[] rslt = new int[]{-1, -1};
        int l = 0, r = numbers.length - 1;
        while (l < r) {
            int sum = numbers[l] + numbers[r];
            if (sum < target) l++;
            else if (sum > target) r--;
            else return new int[]{l + 1, r + 1};
        }
        return rslt;
    }

}
