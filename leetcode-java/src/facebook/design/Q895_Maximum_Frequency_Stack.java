package facebook.design;

import java.util.*;

public class Q895_Maximum_Frequency_Stack {

    class FreqStack {

        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Stack<Integer>> index = new HashMap<>();
        int max = 0;
        public FreqStack() {
        }

        public void push(int x) {
            map.put(x, map.getOrDefault(x, 0)+1);
            index.computeIfAbsent(map.get(x), k -> new Stack<>());
            index.get(map.get(x)).push(x);
            max = Math.max(max, map.get(x));
        }

        public int pop() {
            int result = index.get(max).pop();
            map.put(result, max-1);
            if (index.get(max).isEmpty()) max--;
            return result;
        }

    }

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 */

}
