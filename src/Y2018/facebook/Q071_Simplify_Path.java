package Y2018.facebook;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Q071_Simplify_Path {

    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        Set<String> skip = new HashSet<>(Arrays.asList("..", ".", ""));
        for (String dir : path.split("/")) {
            if (dir.equals("..") && !stack.isEmpty()) {
                stack.pop();
            } else if (!skip.contains(dir)) {
                stack.push(dir);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, "/" + stack.pop());
        }
        return sb.length() == 0 ? "/" : sb.toString();
    }

}
