package Y2020.facebook;

public class Q0238_Product_of_Array_Except_Self {

    public int[] productExceptSelf(int[] nums) {
        int[] rslt = new int[nums.length];
        int tmp = 1;
        for (int i = 0; i < nums.length; i++) {
            rslt[i] = tmp;
            tmp *= nums[i];
        }
        tmp = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            rslt[i] *= tmp;
            tmp *= nums[i];
        }
        return rslt;
    }

}
