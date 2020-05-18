package Y2020.facebook.misc.monotonic_stack_queue;

import java.util.Stack;

public class Q0962_Maximum_Width_Ramp {

    public int maxWidthRamp(int[] A) {
        if (A == null || A.length == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < A.length; i++) {
            if (!stack.isEmpty() && A[stack.peek()] <= A[i]) continue;
            stack.push(i);
        }

        int rslt = 0;
        for (int i = A.length - 1; !stack.isEmpty() && i > rslt; i--) {
            while (!stack.isEmpty() && A[stack.peek()] <= A[i]) {
                rslt = Math.max(rslt, i - stack.pop());
            }
        }
        return rslt;
    }

}
