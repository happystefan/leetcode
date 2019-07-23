package Y2019.misc;

public class Q0010_Identify_Two_Swapped_Elements_In_a_Sorted_Array {

    /*
    Two elements of a sorted array are swapped by mistake.
    Identify the index of the two swapped elements.
    */
    public int[] findTwoSwapped(int[] nums) {
        int x = -1, y = -1;
        for (int i = 1; i <= nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                y = i;
                if (x == -1) x = i - 1;
                else break;
            }
        }
        return new int[]{x, y};
    }

}
