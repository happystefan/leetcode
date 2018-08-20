package archive.facebook;

public class Q477_Total_Hamming_Distance {

    public int totalHammingDistance(int[] nums) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int cnt = 0;
            for (int num : nums) {
                cnt += (num>>i)&1;
            }
            result += cnt*(nums.length-cnt);
        }
        return result;
    }

}
