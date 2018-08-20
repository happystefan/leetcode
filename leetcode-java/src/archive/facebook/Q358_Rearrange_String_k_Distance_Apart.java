package archive.facebook;

public class Q358_Rearrange_String_k_Distance_Apart {


}

/*
class Solution {

    public String rearrangeString(String s, int k) {
        if (k == 0) {
            return s;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        List<Pair> list = new ArrayList<>();
        for (char c : map.keySet()) {
            list.add(new Pair(c, map.get(c)));
        }
        Collections.archive.sort(list, (a, b)->(b.cnt - a.cnt));
        char[] result = new char[s.length()];
        int i = 0;
        for (Pair pair : list) {
            int j = i;
            char c = pair.chr;
            int cnt = pair.cnt;
            while (cnt-- > 0) {
                if (j >= result.length) {
                    return "";
                }
                System.out.printf("%c %d\n", c, j);
                result[j] = c;
                j += k;
            }
            while (i != result.length && result[i] != '\0') i++;
        }
        return new String(result);
    }

    class Pair {
        char chr;
        int cnt;
        public Pair(char chr, int cnt) {
            this.chr = chr;
            this.cnt = cnt;
        }
    }



}
*/