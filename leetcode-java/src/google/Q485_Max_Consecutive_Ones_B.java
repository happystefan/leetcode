package google;

public class Q485_Max_Consecutive_Ones_B {

    public int findMaxConsecutiveOnes(int[] nums) {
        int ans = 0;
        int cnt = 0;
        for (int num : nums) {
            if (num == 1) cnt++;
            else cnt = 0;
            ans = Math.max(ans, cnt);
        }
        return ans;
    }

}
