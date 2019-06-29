package Y2018.divide_and_conquer;

public class Q169_Majority_Element {

    public int majorityElement(int[] nums) {
        int major = 0, cnt = 0;
        for (int num : nums) {
            if (cnt == 0) {
                major = num;
            }
            if (num == major) {
                cnt++;
            } else {
                cnt--;
            }
        }
        return major;
    }

}
