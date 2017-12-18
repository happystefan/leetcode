package Q200_Q299;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by mingqiangliang on 12/18/17.
 */
public class Q241_Different_Ways_to_Add_Parentheses {

    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> ans = new LinkedList<>();
        for (int i = 0; i < input.length(); i++) {
            if (Character.isDigit(input.charAt(i))) {
                continue;
            }
            List<Integer> parta = diffWaysToCompute(input.substring(0, i));
            List<Integer> partb = diffWaysToCompute(input.substring(i+1));
            for (int a : parta) {
                for (int b : partb) {
                    if (input.charAt(i) == '+') ans.add(a+b);
                    if (input.charAt(i) == '-') ans.add(a-b);
                    if (input.charAt(i) == '*') ans.add(a*b);
                }
            }
        }
        if (ans.size() == 0) ans.add(Integer.valueOf(input));
        return ans;
    }

}
