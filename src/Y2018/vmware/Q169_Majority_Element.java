package Y2018.vmware;

public class Q169_Majority_Element {

    public int majorityElement(int[] nums) {
        int major = 0, count = 0;
        for (int num : nums) {
            if (count == 0) major = num;
            if (num == major) count++;
            else count--;
        }
        return major;
    }

}