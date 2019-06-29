package Y2018.facebook.increasing_subsequence;

public class Q334_Increasing_Triplet_Subsequence {

    public boolean increasingTriplet(int[] nums) {
        int small = Integer.MAX_VALUE, big = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num < small) small = num;
            else if (num < big) big = num;
            else if (num > big) return true;
        }
        return false;
    }

}
