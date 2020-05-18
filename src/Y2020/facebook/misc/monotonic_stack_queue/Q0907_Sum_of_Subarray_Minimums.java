package Y2020.facebook.misc.monotonic_stack_queue;

import java.util.Stack;

public class Q0907_Sum_of_Subarray_Minimums {

    private int mod = (int) (1e9 + 7);

    class solution_lookuptable {

        public int sumSubarrayMins(int[] A) {
            if (A == null || A.length == 0) return 0;
            int n = A.length;
            int[] ll = new int[n], rr = new int[n];
            ll[0] = -1;
            rr[n - 1] = n;
            for (int i = 1; i < n; i++) {
                int p = i - 1;
                while (p >= 0 && A[p] >= A[i]) p = ll[p];
                ll[i] = p;
            }
            for (int i = n - 1; i >= 0; i--) {
                int p = i + 1;
                /*
                 * NOTE this is wrong:
                 * while (p < n && A[p] > A[i]) p = rr[p];
                 *
                 * To handle duplicate elements: Set strict less and non-strict less(less than or equal to) for finding
                 * NLE (next less element) and PLE (previous less element) respectively. The order doesn't matter.
                 */
                while (p < n && A[p] > A[i]) p = rr[p];
                rr[i] = p;
            }
            int rslt = 0;
            for (int i = 0; i < n; i++) {
                rslt += (rr[i] - i) * (i - ll[i]) % mod * A[i] % mod;
                rslt %= mod;
            }
            return rslt;
        }

    }

    class solution_twostack {

        public int sumSubarrayMins(int[] A) {
            if (A == null || A.length == 0) return 0;
            int n = A.length;
            int[] ll = new int[n], rr = new int[n];
            Stack<Integer> stack1 = new Stack<>();
            for (int i = 0; i < n; i++) {
                while (!stack1.empty() && A[stack1.peek()] >= A[i]) stack1.pop();
                ll[i] = stack1.isEmpty() ? -1 : stack1.peek();
                stack1.push(i);
            }
            Stack<Integer> stack2 = new Stack<>();
            for (int i = n - 1; i >= 0; i--) {
                /*
                 * NOTE this is wrong:
                 * while (!stack2.isEmpty() && A[stack2.peek()] >= A[i]) stack2.pop();
                 */
                while (!stack2.isEmpty() && A[stack2.peek()] > A[i]) stack2.pop();
                rr[i] = stack2.isEmpty() ? n : stack2.peek();
                stack2.push(i);
            }
            int rslt = 0;
            for (int i = 0; i < n; i++) {
                rslt += (rr[i] - i) * (i - ll[i]) % mod * A[i] % mod;
                rslt %= mod;
            }
            return rslt;
        }

    }

}
