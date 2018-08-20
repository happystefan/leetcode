package archive.google;

import java.util.Stack;

public class Q739_Daily_Temperatures_B {

    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int idx = stack.pop();
                ans[idx] = i-idx;
            }
            stack.push(i);
        }
        return ans;
    }

}
