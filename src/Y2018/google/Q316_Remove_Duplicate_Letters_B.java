package Y2018.google;

import java.util.Stack;

public class Q316_Remove_Duplicate_Letters_B {

    public String removeDuplicateLetters(String s) {
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }
        Stack<Character> stack = new Stack<>();
        boolean[] visited = new boolean[26];
        for (char c : s.toCharArray()) {
            cnt[c - 'a']--;
            if (visited[c - 'a']) {
                continue;
            }
            while (!stack.isEmpty() && stack.peek() > c && cnt[stack.peek() - 'a'] > 0) {
                visited[stack.peek() - 'a'] = false;
                stack.pop();
            }
            stack.push(c);
            visited[c - 'a'] = true;
        }
        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c);
        }
        return sb.toString();
    }

}
