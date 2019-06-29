package facebook;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Q767_Reorganize_String {

    public String reorganizeString(String S) {
        PriorityQueue<Node> Q = new PriorityQueue<>((a, b) -> b.f - a.f);
        Map<Character, Integer> map = new HashMap<>();
        for (char c : S.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c : map.keySet()) {
            Q.offer(new Node(c, map.get(c)));
        }
        StringBuilder sb = new StringBuilder();
        Node prev = null;
        while (!Q.isEmpty()) {
            Node curr = Q.poll();
            if (prev != null && prev.f > 0) {
                Q.offer(prev);
            }
            sb.append(curr.c);
            curr.f--;
            prev = curr;
            if (Q.isEmpty() && prev.f > 0) {
                return "";
            }
        }
        return sb.toString();
    }

    class Node {
        char c;
        int f;

        public Node(char c, int f) {
            this.c = c;
            this.f = f;
        }
    }

}
