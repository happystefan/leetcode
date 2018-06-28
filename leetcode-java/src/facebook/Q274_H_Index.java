package facebook;

import java.util.Arrays;

public class Q274_H_Index {

    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        Arrays.sort(citations);
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < citations.length; i++) {
            int cites = citations[i];
            int papers = citations.length-i;
            result = Math.max(result, Math.min(cites, papers));
        }
        return result;
    }

}
