package divide_and_conquer;

import java.util.*;

public class Q241_Different_Ways_to_Add_Parentheses {

    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                List<Integer> part1 = diffWaysToCompute(input.substring(0, i));
                List<Integer> part2 = diffWaysToCompute(input.substring(i+1));
                for (int a : part1) {
                    for (int b : part2) {
                        if (input.charAt(i) == '+') {
                            result.add(a+b);
                        }
                        if (input.charAt(i) == '-') {
                            result.add(a-b);
                        }
                        if (input.charAt(i) == '*') {
                            result.add(a*b);
                        }
                    }
                }
            }
        }
        if (result.size() == 0) {
            result.add(Integer.valueOf(input));
        }
        return result;
    }

}
