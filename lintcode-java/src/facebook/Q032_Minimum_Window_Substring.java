package facebook;

public class Q032_Minimum_Window_Substring {

    public String minWindow(String source , String target) {
        int[] map = new int[256];
        for (char c : target.toCharArray()) {
            map[c] += 1;
        }

        int targetNum = target.length();
        int sourceNum = 0;
        int l = 0;

        int minLen = Integer.MAX_VALUE;
        String result = "";

        for (int r = 0; r < source.length(); r++) {
            if (map[source.charAt(r)] > 0) {
                sourceNum++;
            }
            map[source.charAt(r)]--;
            while (sourceNum >= targetNum) {

                if (r-l+1 < minLen) {
                    minLen = r-l+1;
                    result = source.substring(l, r+1);
                }

                map[source.charAt(l)]++;
                if (map[source.charAt(l)] > 0) {
                    sourceNum--;
                }
                l++;
            }
        }
        return result;
    }

}
