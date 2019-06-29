package stack;

import java.util.Stack;

public class Q394_Decode_String {

    public String decodeString(String s) {
        Stack<Integer> stacki = new Stack<>();
        Stack<String> stacks = new Stack<>();
        stacks.push("");
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                int j = i;
                while (Character.isDigit(s.charAt(i + 1))) i++;
                stacki.push(Integer.parseInt(s.substring(j, i + 1)));
            } else if (s.charAt(i) == '[') {
                stacks.push("");
            } else if (s.charAt(i) == ']') {
                int cnt = stacki.pop();
                String str = stacks.pop();
                System.out.println(stacks.size());
                StringBuilder sb = new StringBuilder();
                while (cnt-- > 0) {
                    sb.append(str);
                }
                stacks.push(stacks.pop() + sb.toString());
            } else {
                stacks.push(stacks.pop() + s.charAt(i));
            }
        }
        return stacks.pop();
    }

}