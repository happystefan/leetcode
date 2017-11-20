package Q100_Q199;

public class Q169_Majority_Element_C {

    public int majorityElement(int[] nums) {
        int[] bit = new int[32];
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                if (((num >> i) & 1) == 1) bit[i]++;
            }
        }

        int ans = 0;
        for (int i = 0; i < 32; i++) {
            bit[i] = bit[i] > (nums.length/2) ? 1 : 0;
            ans += bit[i] << i;
        }

        return ans;
    }

}
