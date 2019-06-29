package Y2018.vmware;

public class Q169_Majority_Element_B {

    public int majorityElement(int[] nums) {
        int[] bit = new int[32];
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                if (((num >> i) & 1) == 1) bit[i]++;
            }
        }
        int result = 0;
        for (int i = 0; i < 32; i++) {
            if (bit[i] > nums.length / 2) {
                result += 1 << i;
            }
        }
        return result;
    }

}
