package Y2020.facebook.misc.monotonic_stack_queue;

import java.util.Stack;

public class Q0739_Daily_Temperatures {

    public int[] dailyTemperatures(int[] T) {
        if (T == null || T.length == 0) return new int[0];
        int[] rslt = new int[T.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < T.length; i++) {
            while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
                int j = stack.pop();
                rslt[j] = i - j;
            }
            stack.push(i);
        }
        return rslt;
    }

}
