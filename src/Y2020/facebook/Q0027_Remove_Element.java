package Y2020.facebook;

public class Q0027_Remove_Element {

    public int removeElement(int[] nums, int val) {
        int i = 0;
        for (int num : nums) {
            if (num == val) continue;
            nums[i++] = num;
        }
        return i;
    }

}
