package Y2019.parser;

public class Q0439_Ternary_Expression_Parser {

    public String parseTernary(String expression) {
        if (!expression.contains(":")) return expression;
        int idx = -1;
        int cnt = 0;
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '?') cnt++;
            else if (expression.charAt(i) == ':') {
                cnt--;
                if (cnt == 0) {
                    idx = i;
                    break;
                }
            }
        }
        return expression.startsWith("T") ? parseTernary(expression.substring(2, idx)) :
                parseTernary(expression.substring(idx + 1));
    }

}
