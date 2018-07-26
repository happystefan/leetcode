package facebook;

public class Q747_Largest_Number_At_Least_Twice_of_Others {

    public int dominantIndex(int[] nums) {
        int largest = 0;
        int second = 0;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > largest) {
                second = largest;
                largest = nums[i];
                result = i;
            } else if (nums[i] > second) {
                second = nums[i];
            }
        }
        return largest >= second*2 ? result : -1;
    }

}
