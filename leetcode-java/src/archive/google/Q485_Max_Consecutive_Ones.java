package archive.google;

import java.util.Stack;

public class Q485_Max_Consecutive_Ones {

    public int findMaxConsecutiveOnes(int[] nums) {
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        for (int num : nums) {
            if (num == 1) stack.push(num);
            else stack.clear();
            ans = Math.max(ans, stack.size());
        }
        return ans;
    }

}
