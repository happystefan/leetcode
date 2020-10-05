package Y2020.linkedin.algo_part1;

import java.util.Stack;

public class Q002_Function_Time {

    // rslt[0] is inclusive time;
    // rslt[1] is exclusive time;
    void parseFuncTime(String[] input, String funcName, int[] rslt) {
        if (input == null || input.length == 0 || funcName == null) return;
        int i = 0;
        String[] triplet = null;
        while (i < input.length) {
            triplet = input[i].split(",");
            if (triplet[0].equals(funcName) && triplet[1].equals("START")) break;
        }
        if (i == input.length) return;

        Stack<Info> stack = new Stack<>();
        stack.push(new Info(triplet[0], Integer.valueOf(triplet[1]), 0));
        int totalTime = 0;
        int otherTime = 0;
        for (; i < input.length; i++) {
            triplet = input[i].split(",");
            if (triplet[1].equals("START")) {
                stack.push(new Info(triplet[0], Integer.valueOf(triplet[1]), stack.peek().level + 1));
            } else {
                Info info = stack.pop();
                if (info.level > 1) {
                    // do nothing
                } else if (info.level == 1) {
                    otherTime += Integer.valueOf(triplet[2]) - info.time;
                } else if (info.level == 0) {
                    totalTime += Integer.valueOf(triplet[2]) - info.time;
                    break;
                }
            }
        }
        rslt[0] = totalTime;
        rslt[1] = totalTime - otherTime;
    }

    class Info {
        String name;
        int time;
        int level;
        public Info(String name, int time, int level) {
            this.name = name;
            this.time = time;
            this.level = level;
        }
    }
}
