package google;

public class Q274_H_Index_B {

    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) return 0;
        int n = citations.length;
        int[] num = new int[n+1];
        for (int c : citations) {
            if (c > n) num[n]++;
            else num[c]++;
        }
        if (num[n] >= n) return n;
        for (int i = n-1; i >= 0; i--) {
            num[i] += num[i+1];
            if (num[i] >= i) return i;
        }
        return 0;
    }

}
