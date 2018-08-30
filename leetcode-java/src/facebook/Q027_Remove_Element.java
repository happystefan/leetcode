package facebook;

public class Q027_Remove_Element {

    public int removeElement(int[] nums, int val) {
        int k = 0;
        for (int num : nums) {
            if (num != val) nums[k++] = num;
        }
        return k;
    }

}
