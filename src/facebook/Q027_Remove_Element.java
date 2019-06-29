package facebook;

public class Q027_Remove_Element {

    public int removeElement(int[] nums, int val) {
        int l = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                continue;
            }
            nums[l++] = nums[i];
        }
        return l;
    }

}
