package facebook;

public class Q420_Count_and_Say {

    public String countAndSay(int n) {
        char[] result = new char[]{'1'};
        for (int i = 1; i < n; i++) {
            StringBuilder sb = new StringBuilder();

            int cnt = 1;
            char chr = result[0];
            for (int j = 1; j < result.length; j++) {
                if (result[j] == chr) {
                    cnt++;
                } else {
                    sb.append(cnt);
                    sb.append(chr);
                    cnt = 1;
                    chr = result[j];
                }
            }
            sb.append(cnt);
            sb.append(chr);

            result = sb.toString().toCharArray();
        }
        return String.valueOf(result);
    }

}
