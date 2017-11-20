package Q101_Q200;

import java.util.Arrays;

public class Q179_Largest_Number {

    public String largestNumber(int[] nums) {
        String[] numstrs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numstrs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(numstrs, (String s1, String s2) -> (s1+s2).compareTo(s2+s1));
        if (numstrs[numstrs.length-1].equals("0")) return "0";
        StringBuilder ans = new StringBuilder();
        for (int i = numstrs.length-1; i >= 0; i--) {
            ans.append(numstrs[i]);
        }
        return ans.toString();
    }

}
