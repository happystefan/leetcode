package archive.google;

public class Q378_Kth_Smallest_Element_in_a_Sorted_Matrix {

    public int kthSmallest(int[][] matrix, int k) {
        int l = matrix[0][0], h = matrix[matrix.length-1][matrix.length-1];
        while (l < h) {
            int m = l+(h-l)/2;
            int cnt = 0, j = matrix.length-1;
            for (int i = 0; i < matrix.length; i++) {
                while (j >= 0 && matrix[i][j] > m) j--;
                cnt += j+1;
            }
            if (cnt < k) l = m+1;
            else h = m;
        }
        return l;
    }

}
