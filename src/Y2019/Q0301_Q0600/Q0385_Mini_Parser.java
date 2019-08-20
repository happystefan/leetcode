package Y2019.Q0301_Q0600;

import java.util.List;

public class Q0385_Mini_Parser {

    /*
     *------------------------------------------------------------------------------------------------------------------
     *
     * solution 1: substring() is O(N) make the overall time complexity becomes O(N^2)
     *
     *------------------------------------------------------------------------------------------------------------------
     */
    class solution1 {

        String str = null;

        public NestedInteger deserialize(String s) {
            if (s == null) return null;
            str = s;
            return deserialize();
        }

        private NestedInteger deserialize() {
            if (str.startsWith("[]")) {
                str = str.substring(2); // remove "[]"
                return new NestedInteger();
            }
            if (str.startsWith("[")) {
                NestedInteger result = new NestedInteger();
                str = str.substring(1); // remove "["
                result.add(deserialize());
                while (str.startsWith(",")) {
                    str = str.substring(1); // remove ","
                    result.add(deserialize());
                }
                str = str.substring(1); // remove "]"
                return result;
            } else {
                int i = 0;
                int val = 0;
                int flag = 1;
                if (str.startsWith("-")) {
                    i = 1;
                    flag = -1;
                }
                while (i < str.length() && Character.isDigit(str.charAt(i))) {
                    val *= 10;
                    val += str.charAt(i) - '0';
                    i++;
                }
                str = str.substring(i); // remove "<num>"
                return new NestedInteger(val * flag);
            }
        }

    }

    /*
     *------------------------------------------------------------------------------------------------------------------
     *
     * solution 2
     *
     *------------------------------------------------------------------------------------------------------------------
     */
    class solution2 {


        char[] ss = null;
        int pos = 0;

        public NestedInteger deserialize(String s) {
            if (s == null) return null;
            ss = s.toCharArray();
            return deserialize();
        }

        private NestedInteger deserialize() {
            if (pos == ss.length) return null;
            if (ss[pos] == '[' && ss[pos + 1] == ']') {
                pos += 2;
                return new NestedInteger();
            }
            if (ss[pos] == '[') {
                NestedInteger result = new NestedInteger();
                pos++;
                result.add(deserialize());
                while (pos < ss.length && ss[pos] == ',') {
                    pos++;
                    result.add(deserialize());
                }
                pos++;
                return result;
            } else {
                System.out.println(pos);
                int i = pos;
                int flag = 1;
                int val = 0;
                if (ss[i] == '-') {
                    flag = -1;
                    i++;
                }
                while (i < ss.length && Character.isDigit(ss[i])) {
                    val *= 10;
                    val += ss[i] - '0';
                    i++;
                }
                pos = i;
                return new NestedInteger(val * flag);
            }
        }

    }

    /*
     *------------------------------------------------------------------------------------------------------------------
     *
     * solution 3: Xin Li's solution
     *
     *------------------------------------------------------------------------------------------------------------------
     */
    class solution3 {

        char[] ss = null;
        int pos = 0;

        public NestedInteger deserialize(String s) {
            ss = s.toCharArray();
            return deserialize();
        }

        private NestedInteger deserialize() {
            if (pos == ss.length) return new NestedInteger();
            if (ss[pos] == ']') return new NestedInteger();
            NestedInteger tmp = new NestedInteger();
            NestedInteger result = new NestedInteger();
            for (; pos < ss.length; pos++) {
                char c = ss[pos];
                if (Character.isDigit(c) || c == '-') {
                    if (c == '-') pos++;
                    int val = 0;
                    while (pos < ss.length && Character.isDigit(ss[pos])) {
                        val = val * 10 + ss[pos] - '0';
                        pos++;
                    }
                    tmp = new NestedInteger(val * (c == '-' ? -1 : 1));
                    pos--;
                } else if (c == ',') {
                    result.add(tmp);
                } else if (c == ']') {
                    result.add(tmp);
                    return result;
                } else if (c == '[') {
                    pos++;
                    tmp = deserialize();
                }
            }
            return tmp;
        }

    }


    /*
     *------------------------------------------------------------------------------------------------------------------
     *
     * solution 4: standard answer O(N^2)
     *
     *------------------------------------------------------------------------------------------------------------------
     */
    class solution4 {

        public NestedInteger deserialize(String s) {
            if (s == null) return null;
            if (!s.startsWith("[")) return new NestedInteger(Integer.valueOf(s));
            s = s.substring(1, s.length() - 1);
            NestedInteger result = new NestedInteger();
            int cnt = 0, pos = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '[') cnt++;
                else if (c == ']') cnt--;
                else if (c == ',') {
                    if (cnt == 0) {
                        result.add(deserialize(s.substring(pos, i)));
                        pos = i + 1;
                    }
                }
            }
            if (!s.isEmpty()) result.add(deserialize(s.substring(pos)));
            return result;
        }

    }


    class NestedInteger {
        // Constructor initializes an empty nested list.
        NestedInteger() {
        }

        // Constructor initializes a single integer.
        NestedInteger(int value) {
        }

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger() {
            return true;
        }

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger() {
            return 1;
        }


        // Set this NestedInteger to hold a single integer.
        public void setInteger(int value) {
        }

        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        public void add(NestedInteger ni) {
        }

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList() {
            return null;
        }

    }

}
