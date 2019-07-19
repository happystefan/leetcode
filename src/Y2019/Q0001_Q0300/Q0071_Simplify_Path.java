package Y2019.Q0001_Q0300;

import java.util.*;

public class Q0071_Simplify_Path {

    public String simplifyPath(String path) {
        Deque<String> deque = new LinkedList<>();
        Set<String> set = new HashSet<>(Arrays.asList("/", "//", ".", "", ".."));
        for (String dir : path.split("/")) {
            if (dir.equals("..") && !deque.isEmpty()) deque.pollLast();
            else if (!set.contains(dir)) deque.add(dir);
        }
        String result = String.join("/", deque);
        return "/" + result;
    }

}
