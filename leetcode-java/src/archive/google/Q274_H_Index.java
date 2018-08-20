package archive.google;

import java.util.Arrays;

public class Q274_H_Index {

    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) return 0;
        Arrays.sort(citations);
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < citations.length; i++) {
            int cites = citations[i];
            int paper = citations.length-i;
            ans = Math.max(ans, Math.min(cites, paper));
        }
        return ans;
    }

}
