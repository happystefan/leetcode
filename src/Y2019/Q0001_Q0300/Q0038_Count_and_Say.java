package Y2019.Q0001_Q0300;

public class Q0038_Count_and_Say {

    public String countAndSay(int n) {
        char[] ss = new char[]{'1'};
        while (--n > 0) {
            StringBuilder sb = new StringBuilder();
            int l = 0, r = 0;
            while (r < ss.length) {
                while (r < ss.length && ss[r] == ss[l]) r++;
                sb.append(r - l);
                sb.append(ss[l]);
                l = r;
            }
            ss = sb.toString().toCharArray();
        }
        return new String(ss);
    }

}
