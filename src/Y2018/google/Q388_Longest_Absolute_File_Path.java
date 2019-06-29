package Y2018.google;

import java.util.Stack;

public class Q388_Longest_Absolute_File_Path {

    public int lengthLongestPath(String input) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int ans = 0;
        for (String str : input.split("\n")) {
            int level = str.lastIndexOf('\t') + 1;
            while (stack.size() > level + 1) stack.pop();
            stack.push(stack.peek() + str.length() - level + 1);
            if (str.contains(".")) ans = Math.max(ans, stack.peek() - 1);
        }
        return ans;
    }

}
