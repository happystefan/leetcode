package Y2018.google;

import java.math.BigInteger;

public class Q321_Create_Maximum_Number {

    // Time Limit Exceeded: O(2^(m+n))
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        BigInteger maxNum = dfs(nums1, nums2, 0, 0, BigInteger.ZERO, k);
        int[] result = new int[k];
        while (k-- > 0) {
            result[k] = maxNum.mod(BigInteger.TEN).intValue();
            maxNum = maxNum.divide(BigInteger.TEN);
        }
        return result;
    }

    private BigInteger dfs(int[] nums1, int[] nums2, int pos1, int pos2, BigInteger num, int k) {
        if (k == 0 || pos1 == nums1.length && pos2 == nums2.length) {
            return num;
        }
        BigInteger result = num;
        for (int i = pos1; i < nums1.length; i++) {
            result = result.max(dfs(nums1, nums2, i + 1, pos2, num.multiply(BigInteger.TEN).add(BigInteger.valueOf(nums1[i])), k - 1));
        }
        for (int j = pos2; j < nums2.length; j++) {
            result = result.max(dfs(nums1, nums2, pos1, j + 1, num.multiply(BigInteger.TEN).add(BigInteger.valueOf(nums2[j])), k - 1));
        }
        return result;
    }

}
