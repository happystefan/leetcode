package Y2020.facebook;

import java.util.Stack;

public class Q0484_Find_Permutation {

    public int[] findPermutation(String s) {
        char[] ss = s.toCharArray();
        int[] rslt = new int[ss.length + 1];
        Stack<Integer> stack = new Stack<>();
        int pos = 0;
        for (int i = 0; i < ss.length; i++) {
            if (ss[i] == 'I') {
                stack.push(i + 1);
                while (!stack.isEmpty()) {
                    rslt[pos++] = stack.pop();
                }
            } else {
                stack.push(i + 1);
            }
        }
        stack.push(ss.length + 1);
        while (!stack.isEmpty()) rslt[pos++] = stack.pop();
        return rslt;
    }

}
