package Y2020.facebook.misc;

public class Q_Leftmost_Column_with_at_Least_a_One {

    /*
    Leftmost Column with at Least a One
    (This problem is an interactive problem.)

    A binary matrix means that all elements are 0 or 1. For each individual row of the matrix, this row is sorted in
    non-decreasing order.

    Given a row-sorted binary matrix binaryMatrix, return leftmost column index(0-indexed) with at least a 1 in it.
    If such index doesn't exist, return -1.

    You can't access the Binary Matrix directly.  You may only access the matrix using a BinaryMatrix interface:

    BinaryMatrix.get(x, y) returns the element of the matrix at index (x, y) (0-indexed).
    BinaryMatrix.dimensions() returns a list of 2 elements [n, m], which means the matrix is n * m.
    Submissions making more than 1000 calls to BinaryMatrix.get will be judged Wrong Answer.  Also, any solutions that
    attempt to circumvent the judge will result in disqualification.

    For custom testing purposes you're given the binary matrix mat as input in the following four examples. You will
    not have access the binary matrix directly.
    */

    interface BinaryMatrix {
        static int get(int x, int y) {
            return 0;
        }

        static int[] dimensions() {
            return new int[]{0, 0};
        }
    }

    // O(M+N)
    class solutin_topright {

        public int leftmostColumnWithAtLeastAOne() {
            int[] mn = BinaryMatrix.dimensions();
            int rslt = mn[1];
            for (int i = 0; i < mn[0]; i++) {
                while (rslt > 0 && BinaryMatrix.get(i, rslt - 1) == 1) {
                    rslt--;
                }
            }
            return rslt == mn[1] ? -1 : rslt;
        }

    }

    class solutin_bsearch {

        public int leftmostColumnWithAtLeastAOne() {
            int[] mn = BinaryMatrix.dimensions();
            int l = 0, r = mn[1];
            while (l < r) {
                int m = l + (r - l) / 2;
                if (!isValid(m)) {
                    l = m + 1;
                } else {
                    r = m;
                }
            }
            return l;
        }

        private boolean isValid(int col) {
            int[] mn = BinaryMatrix.dimensions();
            for (int i = 0; i < mn[0]; i++) {
                if (BinaryMatrix.get(i, col) == 1) return true;
            }
            return false;
        }

    }

}
