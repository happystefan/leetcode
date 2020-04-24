package Y2020.facebook;

public class Q1198_Find_Smallest_Common_Element_in_All_Rows {

    public int smallestCommonElement(int[][] mat) {
        if (mat == null || mat.length == 0 || mat[0] == null || mat[0].length == 0) return -1;
        int m = mat.length, n = mat[0].length;
        int[] pos = new int[m];
        int max = 0, cnt = 0;
        while (true) {
            for (int i = 0; i < m; i++) {
                while (pos[i] < n && mat[i][pos[i]] < max) pos[i]++;
                if (pos[i] == n) return -1;
                if (max != mat[i][pos[i]]) {
                    max = mat[i][pos[i]];
                    cnt = 1;
                } else {
                    cnt++;
                    if (cnt == m) return max;
                }
            }
        }
    }

}
