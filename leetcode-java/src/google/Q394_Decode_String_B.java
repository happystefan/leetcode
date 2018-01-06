package google;

import java.util.Stack;

public class Q394_Decode_String_B {

    public String decodeString(String s) {
        Stack<Integer> cnt = new Stack<>();
        Stack<String> str = new Stack<>();
        str.push("");
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                int j = i;
                while (Character.isDigit(s.charAt(i+1))) i++;
                cnt.push(Integer.parseInt(s.substring(j, i+1)));
            } else if (s.charAt(i) == '[') {
                str.push("");
            } else if (s.charAt(i) == ']') {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < cnt.peek(); j++) {
                    sb.append(str.peek());
                }
                str.pop();
                cnt.pop();
                str.push(str.pop()+sb.toString());
            } else {
                str.push(str.pop()+s.charAt(i));
            }
        }
        return str.pop();
    }

}
