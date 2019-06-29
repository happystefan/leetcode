package Y2018.Q001_Q300;

import java.util.LinkedList;
import java.util.List;

public class Q229_Majority_Element_II {

    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new LinkedList<>();
        if (nums == null || nums.length == 0) return ans;
        int num1 = nums[0], num2 = nums[0], cnt1 = 0, cnt2 = 0;
        for (int num : nums) {
            if (num == num1) cnt1++;
            else if (num == num2) cnt2++;
            else if (cnt1 == 0) {
                num1 = num;
                cnt1 = 1;
            } else if (cnt2 == 0) {
                num2 = num;
                cnt2 = 1;
            } else {
                cnt1--;
                cnt2--;
            }
        }
        cnt1 = 0;
        cnt2 = 0;
        for (int num : nums) {
            if (num == num1) cnt1++;
            if (num == num2) cnt2++;
        }
        if (cnt1 > nums.length / 3) ans.add(num1);
        if (cnt2 > nums.length / 3 && num2 != num1) ans.add(num2);
        return ans;
    }

}
