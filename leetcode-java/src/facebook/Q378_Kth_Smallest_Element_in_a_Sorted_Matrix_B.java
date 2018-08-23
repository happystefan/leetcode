package facebook;

public class Q378_Kth_Smallest_Element_in_a_Sorted_Matrix_B {

    // 32*N
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        int lo = matrix[0][0], hi = matrix[m-1][n-1];
        while (lo < hi) {
            int mid = lo+(hi-lo)/2;
            int cnt = 0, j = n-1;
            for (int i = 0; i < m; i++) {
                while (j >= 0 && matrix[i][j] > mid) j--;
                cnt += j+1;
                if (j == -1) break;
            }
            if(cnt < k) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

}
