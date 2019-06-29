package Y2018.linkedin;

public class Q287_Find_the_Duplicate_Number {

    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        while (true) {
            fast = nums[nums[fast]];
            slow = nums[slow];
            if (fast == slow) {
                break;
            }
        }
        fast = 0;
        while (fast != slow) {
            fast = nums[fast];
            slow = nums[slow];
        }
        return fast;
    }

}
