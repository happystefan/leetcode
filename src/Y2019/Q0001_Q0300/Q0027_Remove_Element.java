package Y2019.Q0001_Q0300;

public class Q0027_Remove_Element {

    public int removeElement(int[] nums, int val) {
        int l = 0, r = 0;
        while (r < nums.length) {
            while (r < nums.length && nums[r] == val) r++;
            if (r < nums.length) nums[l++] = nums[r++];
        }
        return l;
    }

}
