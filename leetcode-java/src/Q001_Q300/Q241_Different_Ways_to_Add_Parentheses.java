package Q001_Q300;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by mingqiangliang on 12/18/17.
 */
public class Q241_Different_Ways_to_Add_Parentheses {

    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> ans = new LinkedList<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> part1 = diffWaysToCompute(input.substring(0, i));
                List<Integer> part2 = diffWaysToCompute(input.substring(i+1));
                for (int a : part1) {
                    for (int b : part2) {
                       if (c == '+') ans.add(a+b);
                       if (c == '-') ans.add(a-b);
                       if (c == '*') ans.add(a*b);
                    }
                }
            }
        }
        if (ans.size() == 0) ans.add(Integer.valueOf(input));
        return ans;
    }

}
