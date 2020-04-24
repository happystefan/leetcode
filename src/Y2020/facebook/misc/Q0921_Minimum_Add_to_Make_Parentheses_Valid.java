package Y2020.facebook.misc;

public class Q0921_Minimum_Add_to_Make_Parentheses_Valid {

    class solution_two_pass {

        public int minAddToMakeValid(String S) {
            if (S == null || S.length() == 0) return 0;
            char[] ss = S.toCharArray();
            return extra(S.toCharArray(), '(', ')') + extra(new StringBuilder(S).reverse().toString().toCharArray(), ')', '(');
        }

        private int extra(char[] ss, char l, char r) {
            int cnt = 0;
            for (char c : ss) {
                if (c == l) cnt++;
                else cnt--;
                if (cnt < 0) {
                    cnt = 0;
                }
            }
            return cnt;
        }

    }

    class solution_pne_pass {

        public int minAddToMakeValid(String S) {
            if (S == null || S.length() == 0) return 0;
            char[] ss = S.toCharArray();
            int rslt = 0, cnt = 0;
            for (char c : ss) {
                if (c == '(') cnt++;
                else cnt--;
                if (cnt < 0) {
                    rslt++;
                    cnt = 0;
                }
            }
            return rslt + cnt;
        }

    }

}
